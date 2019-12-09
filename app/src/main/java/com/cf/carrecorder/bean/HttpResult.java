package com.cf.carrecorder.bean;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class HttpResult<T> {

    private String code;
    private String msg;
    private T data;

    @Override
    public String toString() {
        return "HttpResult{" +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }





}
