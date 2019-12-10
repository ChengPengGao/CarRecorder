package com.cf.carrecorder.bean;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-10
 * @email androidhcx@163.com
 **/
public class RecordListData {

    /**
     * total : 3
     * rows : [{"id":1,"deviceId":null,"deviceNo":"ss44","photoUrl":"http://www.baidu.com","longitude":154.4564546,"latitude":48845.5555456,"speed":120.55,"uploadTime":454645564}]
     * code : 0
     */

    private int total;
    private int code;
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * id : 1
         * deviceId : null
         * deviceNo : ss44
         * photoUrl : http://www.baidu.com
         * longitude : 154.4564546
         * latitude : 48845.5555456
         * speed : 120.55
         * uploadTime : 454645564
         */

        private int id;
        private Object deviceId;
        private String deviceNo;
        private String photoUrl;
        private double longitude;
        private double latitude;
        private double speed;
        private int uploadTime;
        private String carNo;

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(Object deviceId) {
            this.deviceId = deviceId;
        }

        public String getDeviceNo() {
            return deviceNo;
        }

        public void setDeviceNo(String deviceNo) {
            this.deviceNo = deviceNo;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
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

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public int getUploadTime() {
            return uploadTime;
        }

        public void setUploadTime(int uploadTime) {
            this.uploadTime = uploadTime;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "id=" + id +
                    ", deviceId=" + deviceId +
                    ", deviceNo='" + deviceNo + '\'' +
                    ", photoUrl='" + photoUrl + '\'' +
                    ", longitude=" + longitude +
                    ", latitude=" + latitude +
                    ", speed=" + speed +
                    ", uploadTime=" + uploadTime +
                    ", carNo='" + carNo + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RecordListData{" +
                "total=" + total +
                ", code=" + code +
                ", rows=" + rows +
                '}';
    }
}
