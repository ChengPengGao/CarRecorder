package com.cf.carrecorder.bean.request;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class RegistBean {
    private String userName;
    private String phone;
    private String password;
    private String captcha;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
