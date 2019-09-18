package com.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.springmvc.model.ConfigPropertyDTO;
import com.springmvc.model.ConfigServiceDTO;
import com.springmvc.model.PropertyDTO;
import com.springmvc.model.QueryPropertyDTO;
import com.springmvc.service.ConfigPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: luohanwen
 * @Date: 2019/9/16 17:37
 */

@Controller
@RequestMapping("/app/")
public class AppController {
    @Autowired
    private ConfigPropertyService configPropertyService;

    /**
     * 提供接口，让client主动来拉取数据
     */

    @RequestMapping("property")
    @ResponseBody
    public String getProperty(QueryPropertyDTO queryPropertyDTO){
        //需要将请求者送过来的数据转换一下，塞到自己的dto中

        ConfigServiceDTO configServiceDTO=new ConfigServiceDTO();
        configServiceDTO.setServiceName(queryPropertyDTO.getServiceName());
        configServiceDTO.setEnvironment(queryPropertyDTO.getEnvironment());
        configServiceDTO.setIp(queryPropertyDTO.getIp());
        List<PropertyDTO> propertyDTOList= configPropertyService.getPropertyByService(configServiceDTO);
        return JSON.toJSONString(propertyDTOList);
    }
}
