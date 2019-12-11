package com.cf.carrecorder.bean.request;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-11
 * @email androidhcx@163.com
 **/
public class ReportBean {
    /**
     * 车牌号码
     */
    private String carNo;
    /**
     * 违章照片
     */
    private List<String> photoList;
    /**
     * 违章地址
     */
    private String address;
    /**
     * 经度
     */
    private double longitude;
    /**
     * 纬度
     */
    private double latitude;
    /**
     * 违章类型 1-违章掉头 2-占用应急车道 3-压双黄线
     */
    private int breakType;
    /**
     * 举报时间
     */
    private long breakTime;
    /**
     * 车辆类型 1-黄牌 2-蓝牌 3-黑牌
     */
    private int carType;
    /**
     * 举报类型 1-匿名 2-实名
     */
    private int reportType;
    /**
     * 举报人
     */
    private String reportUser;
    /**
     * 举报人身份证
     */
    private String reportIdcard;
    /**
     * 举报人手机号
     */
    private String reportPhone;
    /**
     * 用户id
     */
    private int userId;

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public List<String> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<String> photoList) {
        this.photoList = photoList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getBreakType() {
        return breakType;
    }

    public void setBreakType(int breakType) {
        this.breakType = breakType;
    }

    public long getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(long breakTime) {
        this.breakTime = breakTime;
    }

    public int getCarType() {
        return carType;
    }

    public void setCarType(int carType) {
        this.carType = carType;
    }

    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public String getReportUser() {
        return reportUser;
    }

    public void setReportUser(String reportUser) {
        this.reportUser = reportUser;
    }

    public String getReportIdcard() {
        return reportIdcard;
    }

    public void setReportIdcard(String reportIdcard) {
        this.reportIdcard = reportIdcard;
    }

    public String getReportPhone() {
        return reportPhone;
    }

    public void setReportPhone(String reportPhone) {
        this.reportPhone = reportPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
