package com.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.springmvc.common.BaseResultDTO;
import com.springmvc.model.ConfigPropertyDTO;
import com.springmvc.model.ConfigServiceDTO;
import com.springmvc.service.ConfigPropertyService;
import com.springmvc.service.ConfigServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/")
public class WebController {

    @Autowired
    private ConfigServerService configServerService;

    @Autowired
    private ConfigPropertyService configPropertyService;

    /**
     * 添加配置，修改或者添加，公用
     * @return
     */
    @RequestMapping(value="property",method = RequestMethod.POST)
    @ResponseBody
    public String addOrUpdateProperty(ConfigServiceDTO configServiceDTO) {
        configServerService.addOrUpdateServer(configServiceDTO);

        BaseResultDTO resultDTO=new BaseResultDTO();
        resultDTO.setCode(0);
        return JSON.toJSONString(resultDTO);
    }


    @RequestMapping(value = "property",method = RequestMethod.DELETE)
    public String delProperty(Integer serviceId){
        configServerService.deleteServer(serviceId);
        return null;
    }

    /**
     * 添加服务
     */
    @RequestMapping(value = "service",method = RequestMethod.POST)
    @ResponseBody
    public String addOrUpdateService(ConfigPropertyDTO configPropertyDTO){
        configPropertyService.addOrUpdateProperty(configPropertyDTO);
        return null;
    }

    @RequestMapping(value = "service",method = RequestMethod.DELETE)
    public String delService(){
        return null;
    }
}
