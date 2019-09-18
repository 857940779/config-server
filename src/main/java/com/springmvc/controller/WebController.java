package com.springmvc.controller;

import com.springmvc.model.ConfigServiceDTO;
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

    /**
     * 添加配置，修改或者添加，公用
     * @return
     */
    @RequestMapping(value="property",method = RequestMethod.POST)
    @ResponseBody
    public String addOrUpdateProperty(ConfigServiceDTO configServiceDTO) {
        configServerService.addOrUpdateServer(configServiceDTO);
        return null;
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
    public String addOrUpdateService(){
        return null;
    }

    @RequestMapping(value = "service",method = RequestMethod.DELETE)
    public String delService(){
        return null;
    }
}
