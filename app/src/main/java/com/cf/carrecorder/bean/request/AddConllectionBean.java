package com.cf.carrecorder.bean.request;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-16
 * @email androidhcx@163.com
 **/
public class AddConllectionBean {
    private String userId;
    private List<Integer> drivingList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Integer> getDrivingList() {
        return drivingList;
    }

    public void setDrivingList(List<Integer> drivingList) {
        this.drivingList = drivingList;
    }
}
