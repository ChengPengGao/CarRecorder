package com.cf.carrecorder.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-10
 * @email androidhcx@163.com
 **/
public class RecordListData {

    /**
     * total : 1
     * code : 0
     * rows : [{"deviceList":[{"latitude":30.15669288,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/b812d4ea82f461c5f727127e501b00ef.jpg","carNo":"暂无车牌","id":1686,"longitude":120.13748709,"exponent":64,"deviceNo":"1233333","params":{},"uploadTime":1578974190725,"breakSatus":0},{"latitude":30.15669288,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/44b30ff068122f8c35cb3bfcd4d469c9.jpg","carNo":"暂无车牌","id":1685,"longitude":120.13748709,"exponent":67,"deviceNo":"1233333","params":{},"uploadTime":1578974180130,"breakSatus":0},{"latitude":30.15658121,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/1c7d290cd5de19bf4f3303100ac99483.jpg","carNo":"暂无车牌","id":1684,"longitude":120.13748708,"exponent":69,"deviceNo":"1233333","params":{},"uploadTime":1578974169747,"breakSatus":0},{"latitude":30.15673,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/891732d98da308e0ac4595b4b08b0bdb.jpg","carNo":"暂无车牌","id":1683,"longitude":120.13714124,"exponent":61,"deviceNo":"1233333","params":{},"uploadTime":1578974159514,"breakSatus":0},{"latitude":30.15761101,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/18e718657d04b803c9680a112e58aa40.jpg","carNo":"暂无车牌","id":1682,"longitude":120.13638142,"exponent":69,"deviceNo":"1233333","params":{},"uploadTime":1578974149258,"breakSatus":0},{"latitude":30.15879219,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/8fef3207e0a0130d1e25b61d34e1375c.jpg","carNo":"暂无车牌","id":1681,"longitude":120.13548025,"exponent":70,"deviceNo":"1233333","params":{},"uploadTime":1578974138876,"breakSatus":1},{"latitude":30.16003119,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/b27b9abf2d32ffa176f2c69f5e19d6ae.jpg","carNo":"暂无车牌","id":1680,"longitude":120.13497816,"exponent":67,"deviceNo":"1233333","params":{},"uploadTime":1578974128683,"breakSatus":0},{"latitude":30.1606467,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/af9333aecf4d91859b64985df5d645c1.jpg","carNo":"暂无车牌","id":1679,"longitude":120.13458577,"exponent":62,"deviceNo":"1233333","params":{},"uploadTime":1578974118468,"breakSatus":0},{"latitude":30.16110711,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/f54d82ef03ac63939324d63a16eda0e7.jpg","carNo":"暂无车牌","id":1678,"longitude":120.13426486,"exponent":63,"deviceNo":"1233333","params":{},"uploadTime":1578974107986,"breakSatus":0},{"latitude":30.16207961,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/7b920552ba0c57935ab16c6f38bdb277.jpg","carNo":"暂无车牌","id":1677,"longitude":120.13359643,"exponent":65,"deviceNo":"1233333","params":{},"uploadTime":1578974097616,"breakSatus":0}],"time":"2020-01-14"}]
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
         * deviceList : [{"latitude":30.15669288,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/b812d4ea82f461c5f727127e501b00ef.jpg","carNo":"暂无车牌","id":1686,"longitude":120.13748709,"exponent":64,"deviceNo":"1233333","params":{},"uploadTime":1578974190725,"breakSatus":0},{"latitude":30.15669288,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/44b30ff068122f8c35cb3bfcd4d469c9.jpg","carNo":"暂无车牌","id":1685,"longitude":120.13748709,"exponent":67,"deviceNo":"1233333","params":{},"uploadTime":1578974180130,"breakSatus":0},{"latitude":30.15658121,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/1c7d290cd5de19bf4f3303100ac99483.jpg","carNo":"暂无车牌","id":1684,"longitude":120.13748708,"exponent":69,"deviceNo":"1233333","params":{},"uploadTime":1578974169747,"breakSatus":0},{"latitude":30.15673,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/891732d98da308e0ac4595b4b08b0bdb.jpg","carNo":"暂无车牌","id":1683,"longitude":120.13714124,"exponent":61,"deviceNo":"1233333","params":{},"uploadTime":1578974159514,"breakSatus":0},{"latitude":30.15761101,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/18e718657d04b803c9680a112e58aa40.jpg","carNo":"暂无车牌","id":1682,"longitude":120.13638142,"exponent":69,"deviceNo":"1233333","params":{},"uploadTime":1578974149258,"breakSatus":0},{"latitude":30.15879219,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/8fef3207e0a0130d1e25b61d34e1375c.jpg","carNo":"暂无车牌","id":1681,"longitude":120.13548025,"exponent":70,"deviceNo":"1233333","params":{},"uploadTime":1578974138876,"breakSatus":1},{"latitude":30.16003119,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/b27b9abf2d32ffa176f2c69f5e19d6ae.jpg","carNo":"暂无车牌","id":1680,"longitude":120.13497816,"exponent":67,"deviceNo":"1233333","params":{},"uploadTime":1578974128683,"breakSatus":0},{"latitude":30.1606467,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/af9333aecf4d91859b64985df5d645c1.jpg","carNo":"暂无车牌","id":1679,"longitude":120.13458577,"exponent":62,"deviceNo":"1233333","params":{},"uploadTime":1578974118468,"breakSatus":0},{"latitude":30.16110711,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/f54d82ef03ac63939324d63a16eda0e7.jpg","carNo":"暂无车牌","id":1678,"longitude":120.13426486,"exponent":63,"deviceNo":"1233333","params":{},"uploadTime":1578974107986,"breakSatus":0},{"latitude":30.16207961,"deviceId":3,"speed":1,"photoUrl":"http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/7b920552ba0c57935ab16c6f38bdb277.jpg","carNo":"暂无车牌","id":1677,"longitude":120.13359643,"exponent":65,"deviceNo":"1233333","params":{},"uploadTime":1578974097616,"breakSatus":0}]
         * time : 2020-01-14
         */

        private String time;
        private List<DeviceListBean> deviceList;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public List<DeviceListBean> getDeviceList() {
            return deviceList;
        }

        public void setDeviceList(List<DeviceListBean> deviceList) {
            this.deviceList = deviceList;
        }

        public static class DeviceListBean {
            /**
             * latitude : 30.15669288
             * deviceId : 3
             * speed : 1.0
             * photoUrl : http://carpicstore.oss-cn-hangzhou.aliyuncs.com/image/202001/b812d4ea82f461c5f727127e501b00ef.jpg
             * carNo : 暂无车牌
             * id : 1686
             * longitude : 120.13748709
             * exponent : 64
             * deviceNo : 1233333
             * params : {}
             * uploadTime : 1578974190725
             * breakSatus : 0
             */

            private double latitude;
            private int deviceId;
            private double speed;
            private String photoUrl;
            private String carNo;
            private int id;
            private double longitude;
            private int exponent;
            private String deviceNo;
            private ParamsBean params;
            private long uploadTime;
            private int breakSatus;

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public int getDeviceId() {
                return deviceId;
            }

            public void setDeviceId(int deviceId) {
                this.deviceId = deviceId;
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

            public String getDeviceNo() {
                return deviceNo;
            }

            public void setDeviceNo(String deviceNo) {
                this.deviceNo = deviceNo;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public long getUploadTime() {
                return uploadTime;
            }

            public void setUploadTime(long uploadTime) {
                this.uploadTime = uploadTime;
            }

            public int getBreakSatus() {
                return breakSatus;
            }

            public void setBreakSatus(int breakSatus) {
                this.breakSatus = breakSatus;
            }

            public static class ParamsBean {
            }
        }
    }
}
