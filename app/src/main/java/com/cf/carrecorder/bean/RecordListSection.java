package com.cf.carrecorder.bean;

import com.cf.carrecorder.bean.request.RecordListBean;
import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * @author chenxihu
 * @date 2020-01-14
 * @email androidhcx@163.com
 **/
public class RecordListSection extends SectionEntity<RecordListData.RowsBean.DeviceListBean> {
    public RecordListSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public RecordListSection(RecordListData.RowsBean.DeviceListBean bean) {
        super(bean);
    }

}
