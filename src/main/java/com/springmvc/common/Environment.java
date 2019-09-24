package com.springmvc.common;

/**
 * @Author: luohanwen
 * @Date: 2019/9/18 9:48
 * 环境枚举类
 * 1-dev，2-test，3-uat，4-线上
 */
public enum  Environment {
    DEV(1,"DEV"),
    TEST(2,"TEST"),
    UAT(3,"UAT"),
    PROD(4,"生产");


    public int code;
    public String name;

    Environment(int code,String name){
        this.code=code;
        this.name=name;
    }

    public static String getNameByCode(int code){
        Environment[] environments=Environment.values();
        for(Environment environment:environments){
            if(environment.code==code){
                return environment.name;
            }
        }
        return null;
    }
}
