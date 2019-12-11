package com.cf.carrecorder.bean.request;

/**
 * @author chenxihu
 * @date 2019-12-11
 * @email androidhcx@163.com
 **/
public class ReportListBean {
    private String userId;
    private int auditStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }
}
