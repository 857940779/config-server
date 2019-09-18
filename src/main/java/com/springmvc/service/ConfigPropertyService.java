package com.springmvc.service;

import com.springmvc.model.ConfigPropertyDTO;
import com.springmvc.model.ConfigServiceDTO;
import com.springmvc.model.PropertyDTO;

import java.util.List;

/**
 * @Author: luohanwen
 * @Date: 2019/9/17 17:02
 *
 * 服务配置接口类
 */
public interface ConfigPropertyService {
     int addOrUpdateProperty(ConfigPropertyDTO configPropertyDTO) ;

     List<PropertyDTO> getPropertyByService(ConfigServiceDTO configServiceDTO);
}
