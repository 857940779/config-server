package com.springmvc.model;

/**
 * @Author: luohanwen
 * @Date: 2019/9/18 14:22
 * app获取配置的请求对象
 */
public class QueryPropertyDTO {
    private String ip; //注意，这个是client端服务器的ip
    private Integer environment;    //对应不同的环境
    private String serviceName;     //服务名称

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getEnvironment() {
        return environment;
    }

    public void setEnvironment(Integer environment) {
        this.environment = environment;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
