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
     * 添加服务
     * @return
     */
    @RequestMapping(value="service",method = RequestMethod.POST)
    @ResponseBody
    public String addOrUpdateService(ConfigServiceDTO configServiceDTO) {
        configServerService.addOrUpdateServer(configServiceDTO);

        BaseResultDTO resultDTO=new BaseResultDTO();
        resultDTO.setCode(0);
        return JSON.toJSONString(resultDTO);
    }


    @RequestMapping(value = "service",method = RequestMethod.DELETE)
    public String delProperty(Integer serviceId){
        configServerService.deleteServer(serviceId);
        return null;
    }

    /**
     * 添加配置
     */
    @RequestMapping(value = "property",method = RequestMethod.POST)
    @ResponseBody
    public String addOrUpdateProperty(ConfigPropertyDTO configPropertyDTO){
        configPropertyService.addOrUpdateProperty(configPropertyDTO);
        return null;
    }

    @RequestMapping(value = "property",method = RequestMethod.DELETE)
    public String delService(){
        return null;
    }
}
