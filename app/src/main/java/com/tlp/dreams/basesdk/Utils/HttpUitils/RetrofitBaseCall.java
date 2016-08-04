package com.tlp.dreams.basesdk.Utils.HttpUitils;

/**
 * author  ：tlp
 * create  ： 16/7/28
 * email   ：18772115876@163.com
 * content ：封装基础类
 */
public class RetrofitBaseCall<T> {

    private  int code;
    private String msg;
    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
