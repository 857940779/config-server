package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: luohanwen
 * @Date: 2019/9/16 17:37
 */

@Controller
@RequestMapping("/app/")
public class AppController {

    /**
     * 提供接口，让client主动来拉取数据
     */

    @RequestMapping("property")
    @ResponseBody
    public String getProperty(){
        return null;
    }
}
