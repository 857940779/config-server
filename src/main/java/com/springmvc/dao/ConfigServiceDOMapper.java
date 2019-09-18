package com.springmvc.dao;

import com.springmvc.dbdo.ConfigServiceDO;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface ConfigServiceDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfigServiceDO record);

    int insertSelective(ConfigServiceDO record);

    ConfigServiceDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfigServiceDO record);

    int updateByPrimaryKey(ConfigServiceDO record);

    //根据ip，环境变量,服务名获取服务
    ConfigServiceDO getServerByIPAndEnvirAndServiceName(ConfigServiceDO configServiceDO);
}