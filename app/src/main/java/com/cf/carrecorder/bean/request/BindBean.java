package com.cf.carrecorder.bean.request;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class BindBean {

    private int userId;
    private String deviceNo;
    private String devCode;
    private String deviceAlias;

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getDeviceAlias() {
        return deviceAlias;
    }

    public void setDeviceAlias(String deviceAlias) {
        this.deviceAlias = deviceAlias;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }
}
