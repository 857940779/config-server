package com.springmvc.dao;

import com.springmvc.dbdo.ServicePropertyMapperDO;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface ServicePropertyMapperDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServicePropertyMapperDO record);

    int insertSelective(ServicePropertyMapperDO record);

    ServicePropertyMapperDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServicePropertyMapperDO record);

    int updateByPrimaryKey(ServicePropertyMapperDO record);

    int delByServiceId(Integer servcieId);
}