package com.springmvc.service.impl;

import com.alibaba.fastjson.JSON;
import com.springmvc.dao.ConfigPropertiesDOMapper;
import com.springmvc.dao.ConfigServiceDOMapper;
import com.springmvc.dao.ServicePropertyMapperDOMapper;
import com.springmvc.dbdo.ConfigPropertiesDO;
import com.springmvc.dbdo.ConfigServiceDO;
import com.springmvc.dbdo.ServicePropertyMapperDO;
import com.springmvc.model.ConfigPropertyDTO;
import com.springmvc.model.ConfigServiceDTO;
import com.springmvc.model.PropertyDTO;
import com.springmvc.service.ConfigPropertyService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: luohanwen
 * @Date: 2019/9/18 11:12
 */

@Service
public class ConfigPropertyServiceImpl implements ConfigPropertyService {
    @Autowired
    private ServicePropertyMapperDOMapper servicePropertyMapperDOMapper;

    @Autowired
    private ConfigPropertiesDOMapper configPropertiesDOMapper;

    @Autowired
    private ConfigServiceDOMapper configServiceDOMapper;

    @Override
    @Transactional(isolation= Isolation.READ_COMMITTED,propagation= Propagation.REQUIRED)
    public int addOrUpdateProperty(ConfigPropertyDTO configPropertyDTO) {
        //先去数据库映射表，查询有无配置，如果有，那么修改，如果没有，那么插入
        ServicePropertyMapperDO servicePropertyMapperDO=servicePropertyMapperDOMapper.queryByServiceId(configPropertyDTO.getServiceId());
        if(servicePropertyMapperDO==null){
            //需要先插入配置，然后插入到映射
            ConfigPropertiesDO configPropertiesDO=new ConfigPropertiesDO();
            configPropertiesDO.setProperties(JSON.toJSONString(configPropertyDTO.getList()));
            configPropertiesDO.setCreateTime(new Date());
            configPropertiesDO.setCreator("test");
            configPropertiesDOMapper.insert(configPropertiesDO);

            servicePropertyMapperDO=new ServicePropertyMapperDO();
            servicePropertyMapperDO.setPropertyId(configPropertiesDO.getId());
            servicePropertyMapperDO.setServiceId(configPropertyDTO.getServiceId());
            servicePropertyMapperDO.setState(1);
            servicePropertyMapperDOMapper.insert(servicePropertyMapperDO);
        }else{
            //直接把原来的配置，整个json串替换
            Integer propertyId=servicePropertyMapperDO.getPropertyId();
            ConfigPropertiesDO configPropertiesDO=configPropertiesDOMapper.selectByPrimaryKey(propertyId);

            configPropertiesDO.setProperties(JSON.toJSONString(configPropertyDTO.getList()));
            configPropertiesDOMapper.updateByPrimaryKey(configPropertiesDO);
        }

        return 1;
    }

    @Override
    public List<PropertyDTO> getPropertyByService(ConfigServiceDTO configServiceDTO) {
        //通过server信息，找到映射的property，把property的json串解析一下，返回给app
        ConfigServiceDO param=new ConfigServiceDO();
        param.setIp(configServiceDTO.getIp());
        param.setServiceName(configServiceDTO.getServiceName());
        param.setEnvironment(configServiceDTO.getEnvironment());

        ConfigServiceDO configServiceDO=configServiceDOMapper.getServerByIPAndEnvirAndServiceName(param);
        if(configServiceDO==null){
            return null;
        }

        //要先去映射表查询propertyid，再查询property，因为配置表里面没有服务id
        ServicePropertyMapperDO servicePropertyMapperDO=servicePropertyMapperDOMapper.queryByServiceId(configServiceDO.getId());
        if(servicePropertyMapperDO==null){
            return null;
        }

        ConfigPropertiesDO configPropertiesDO=configPropertiesDOMapper.selectByPrimaryKey(servicePropertyMapperDO.getPropertyId());
        if(configPropertiesDO==null || StringUtils.isEmpty(configPropertiesDO.getProperties())){
            return null;
        }

        List<PropertyDTO> list=JSON.parseArray(configPropertiesDO.getProperties(),PropertyDTO.class);
        return list;
    }
}
