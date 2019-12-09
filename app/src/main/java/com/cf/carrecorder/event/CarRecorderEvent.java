package com.cf.carrecorder.event;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class CarRecorderEvent {

    public static final int LOGIN = 1;


    public static final int BIND = 2;

    /**
     * 用于表示操作码
     */
    private int type;

    /**
     * 自定义中解析出来的消息
     */
    private String msg;

    public CarRecorderEvent(int type) {
        this.type = type;
    }

    public CarRecorderEvent(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
