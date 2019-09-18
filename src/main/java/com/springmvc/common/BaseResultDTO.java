package com.springmvc.common;

/**
 * @Author: luohanwen
 * @Date: 2019/9/18 11:16
 * 公共返回对象
 */
public class BaseResultDTO<T> {
    private Integer code;   //返回码，默认0为成功
    private String msg;     //错误信息
    private T data;    //返回数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
