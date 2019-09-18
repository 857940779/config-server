package com.springmvc.service.impl;

import com.springmvc.dao.ConfigServiceDOMapper;
import com.springmvc.dao.ServicePropertyMapperDOMapper;
import com.springmvc.model.ConfigServiceDTO;
import com.springmvc.service.ConfigServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: luohanwen
 * @Date: 2019/9/17 17:07
 */

@Service
public class ConfigServerServiceImpl implements ConfigServerService{
    @Autowired
    private ConfigServiceDOMapper configServiceDOMapper;

    @Autowired
    private ServicePropertyMapperDOMapper servicePropertyMapperDOMapper;

    @Override
    public int addOrUpdateServer(ConfigServiceDTO configServiceDTO) {
        if(configServiceDTO.getId()==null || configServiceDTO.getId()==0){
            //插入
            configServiceDOMapper.insert(configServiceDTO);
        }else{
            configServiceDOMapper.updateByPrimaryKey(configServiceDTO);
        }

        return 1;
    }

    @Override
    public int deleteServer(Integer serviceId) {
        configServiceDOMapper.deleteByPrimaryKey(serviceId);
        servicePropertyMapperDOMapper.delByServiceId(serviceId);
        return 1;
    }
}
