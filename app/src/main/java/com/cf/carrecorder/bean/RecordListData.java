package com.cf.carrecorder.bean;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-10
 * @email androidhcx@163.com
 **/
public class RecordListData {

    /**
     * total : 152
     * code : 0
     * rows : [{"latitude":30.232505,"deviceNo":"1233333","uploadTime":1576766031721,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/d3a4fd64750438b2e60aa84860266a11.jpg","carNo":"暂无车牌","breakSatus":1,"id":160,"longitude":119.926636,"exponent":97},{"latitude":30.232505,"deviceNo":"1233333","uploadTime":1576766021218,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/3f9d939a4644bdeeefe124eb06060d55.jpg","carNo":"暂无车牌","breakSatus":0,"id":159,"longitude":119.926636,"exponent":43},{"latitude":30.232505,"deviceNo":"1233333","uploadTime":1576765984644,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/50271d3897d76caf6fce7df79a1b2fbb.jpg","carNo":"暂无车牌","breakSatus":1,"id":158,"longitude":119.926636,"exponent":86},{"latitude":30.232505,"deviceNo":"1233333","uploadTime":1576765936950,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/205bdec3a41b775f35ae2ec29d988327.jpg","carNo":"暂无车牌","breakSatus":1,"id":157,"longitude":119.926636,"exponent":72},{"latitude":30.232505,"deviceNo":"1233333","uploadTime":1576765629733,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/3333164e361322b8dcd7792e0dde9ed1.jpg","carNo":"暂无车牌","breakSatus":0,"id":156,"longitude":119.926636,"exponent":21},{"latitude":30.232505,"deviceNo":"1233333","uploadTime":1576765619321,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/99aa90caa5be1f52f9a700c1f882a546.jpg","carNo":"暂无车牌","breakSatus":1,"id":155,"longitude":119.926636,"exponent":97},{"latitude":30.232505,"deviceNo":"1233333","uploadTime":1576765608798,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/cd6c0f1cb648c88035ab76404b89c0bc.jpg","carNo":"暂无车牌","breakSatus":1,"id":154,"longitude":119.926636,"exponent":88},{"latitude":30.232505,"deviceNo":"1233333","uploadTime":1576765270268,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/19fc271069a54244ad5e30906a217a10.jpg","carNo":"暂无车牌","breakSatus":0,"id":153,"longitude":119.926636,"exponent":64},{"latitude":30.232505,"deviceNo":"1233333","uploadTime":1576765099754,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/5d085444fdaa519ed02d5f036a6923a1.jpg","carNo":"暂无车牌","breakSatus":0,"id":152,"longitude":119.926636,"exponent":31},{"latitude":30.232505,"deviceNo":"1233333","uploadTime":1576765051562,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/a7fa9ab32ab46c3026273c1aa0d3754d.jpg","carNo":"暂无车牌","breakSatus":1,"id":151,"longitude":119.926636,"exponent":94}]
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
         * latitude : 30.232505
         * deviceNo : 1233333
         * uploadTime : 1576766031721
         * speed : 1.0
         * photoUrl : http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/201912/d3a4fd64750438b2e60aa84860266a11.jpg
         * carNo : 暂无车牌
         * breakSatus : 1
         * id : 160
         * longitude : 119.926636
         * exponent : 97
         */

        private double latitude;
        private String deviceNo;
        private long uploadTime;
        private double speed;
        private String photoUrl;
        private String carNo;
        private int breakSatus;
        private int id;
        private double longitude;
        private int exponent;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getDeviceNo() {
            return deviceNo;
        }

        public void setDeviceNo(String deviceNo) {
            this.deviceNo = deviceNo;
        }

        public long getUploadTime() {
            return uploadTime;
        }

        public void setUploadTime(long uploadTime) {
            this.uploadTime = uploadTime;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public int getBreakSatus() {
            return breakSatus;
        }

        public void setBreakSatus(int breakSatus) {
            this.breakSatus = breakSatus;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public int getExponent() {
            return exponent;
        }

        public void setExponent(int exponent) {
            this.exponent = exponent;
        }
    }
}
