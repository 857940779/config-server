package com.springmvc.model;

/**
 * @Author: luohanwen
 * @Date: 2019/9/17 16:54
 * 前端添加配置上传的对象
 */
public class ConfigPropertyDTO {
    private Integer serviceId;  //服务id
    private String str;         //配置的json串

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
