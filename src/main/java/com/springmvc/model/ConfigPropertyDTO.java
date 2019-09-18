package com.springmvc.model;

import java.util.List;

/**
 * @Author: luohanwen
 * @Date: 2019/9/17 16:54
 * 前端添加配置上传的对象
 */
public class ConfigPropertyDTO {
    private Integer serviceId;  //服务id
    private List<PropertyDTO> list;         //配置信息

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public List<PropertyDTO> getList() {
        return list;
    }

    public void setList(List<PropertyDTO> list) {
        this.list = list;
    }
}
