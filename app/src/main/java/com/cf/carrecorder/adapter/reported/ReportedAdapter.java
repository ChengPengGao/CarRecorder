package com.cf.carrecorder.adapter.reported;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cf.carrecorder.R;
import com.cf.carrecorder.bean.ReportedBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-10
 * @email androidhcx@163.com
 **/
public class ReportedAdapter extends BaseQuickAdapter<ReportedBean, BaseViewHolder> {
    public ReportedAdapter(@Nullable List<ReportedBean> data) {
        super(R.layout.item_item, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ReportedBean item) {
        helper
                .setText(R.id.tv_type, item.getType())
                .setText(R.id.tv_time, item.getTime())
                .setText(R.id.tv_status,item.getStatus());


    }
}
