package com.cf.carrecorder.bean;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-11
 * @email androidhcx@163.com
 **/
public class ReportListData {

    /**
     * total : 2
     * code : 0
     * rows : [{"photoList":["http://img4.imgtn.bdimg.com/it/u=1544922432","3408838646&fm=26&gp=0.jpg"],"reportUser":"哦婆婆","reportIdcard":"318463315529431111","breakType":2,"latitude":0,"reportType":2,"carType":3,"carNo":"浙D16753","id":23,"longitude":0,"address":"送 ","photo":"http://img4.imgtn.bdimg.com/it/u=1544922432,3408838646&fm=26&gp=0.jpg","params":{},"reportPhone":"18668190036","breakTime":1576059301908,"auditStatus":0,"reportTime":1576052278775},{"photoList":["http://img4.imgtn.bdimg.com/it/u=1544922432","3408838646&fm=26&gp=0.jpg"],"reportUser":"民生","reportIdcard":"210433111499993375","breakType":3,"latitude":0,"reportType":2,"carType":2,"carNo":"浙A12345","id":22,"longitude":0,"address":"杭州","photo":"http://img4.imgtn.bdimg.com/it/u=1544922432,3408838646&fm=26&gp=0.jpg","params":{},"reportPhone":"18668190036","breakTime":1576059353348,"auditStatus":0,"reportTime":1576051968106}]
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
         * photoList : ["http://img4.imgtn.bdimg.com/it/u=1544922432","3408838646&fm=26&gp=0.jpg"]
         * reportUser : 哦婆婆
         * reportIdcard : 318463315529431111
         * breakType : 2
         * latitude : 0.0
         * reportType : 2
         * carType : 3
         * carNo : 浙D16753
         * id : 23
         * longitude : 0.0
         * address : 送
         * photo : http://img4.imgtn.bdimg.com/it/u=1544922432,3408838646&fm=26&gp=0.jpg
         * params : {}
         * reportPhone : 18668190036
         * breakTime : 1576059301908
         * auditStatus : 0
         * reportTime : 1576052278775
         */

        private String reportUser;
        private String reportIdcard;
        private int breakType;
        private double latitude;
        private int reportType;
        private int carType;
        private String carNo;
        private int id;
        private double longitude;
        private String address;
        private String photo;
        private ParamsBean params;
        private String reportPhone;
        private long breakTime;
        private int auditStatus;
        private long reportTime;
        private List<String> photoList;

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

        public int getBreakType() {
            return breakType;
        }

        public void setBreakType(int breakType) {
            this.breakType = breakType;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public int getReportType() {
            return reportType;
        }

        public void setReportType(int reportType) {
            this.reportType = reportType;
        }

        public int getCarType() {
            return carType;
        }

        public void setCarType(int carType) {
            this.carType = carType;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public String getReportPhone() {
            return reportPhone;
        }

        public void setReportPhone(String reportPhone) {
            this.reportPhone = reportPhone;
        }

        public long getBreakTime() {
            return breakTime;
        }

        public void setBreakTime(long breakTime) {
            this.breakTime = breakTime;
        }

        public int getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(int auditStatus) {
            this.auditStatus = auditStatus;
        }

        public long getReportTime() {
            return reportTime;
        }

        public void setReportTime(long reportTime) {
            this.reportTime = reportTime;
        }

        public List<String> getPhotoList() {
            return photoList;
        }

        public void setPhotoList(List<String> photoList) {
            this.photoList = photoList;
        }

        public static class ParamsBean {
        }
    }
}
