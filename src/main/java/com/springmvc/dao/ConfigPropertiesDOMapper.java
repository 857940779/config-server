package com.springmvc.dao;

import com.springmvc.dbdo.ConfigPropertiesDO;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface ConfigPropertiesDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ConfigPropertiesDO record);

    int insertSelective(ConfigPropertiesDO record);

    ConfigPropertiesDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConfigPropertiesDO record);

    int updateByPrimaryKeyWithBLOBs(ConfigPropertiesDO record);

    int updateByPrimaryKey(ConfigPropertiesDO record);
}