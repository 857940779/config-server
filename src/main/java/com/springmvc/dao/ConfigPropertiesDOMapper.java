package com.springmvc.dao;

import com.springmvc.dbdo.ConfigPropertiesDO;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface ConfigPropertiesDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ConfigPropertiesDO record);

    int insertSelective(ConfigPropertiesDO record);

    ConfigPropertiesDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfigPropertiesDO record);


    int updateByPrimaryKey(ConfigPropertiesDO record);

}