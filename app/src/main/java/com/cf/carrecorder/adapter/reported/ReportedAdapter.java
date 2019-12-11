package com.cf.carrecorder.adapter.reported;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cf.carrecorder.R;
import com.cf.carrecorder.bean.ReportListData;
import com.cf.carrecorder.bean.ReportedBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-10
 * @email androidhcx@163.com
 **/
public class ReportedAdapter extends BaseQuickAdapter<ReportListData.RowsBean, BaseViewHolder> {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ReportedAdapter(@Nullable List<ReportListData.RowsBean> data) {
        super(R.layout.item_item, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ReportListData.RowsBean item) {
        String breakType = "";
        switch (item.getBreakType()) {
            case 1:
                breakType = "违章掉头";
                break;
            case 2:
                breakType = "占用应急车道";
                break;
            case 3:
                breakType = "压双黄线";
                break;
            default:
                break;
        }

        String reportType;
        switch (item.getAuditStatus()) {
            case 0:
                reportType = "待审核";
                break;
            case 1:
                reportType = "审核成功";
                break;
            case 2:
                reportType = "审核失败";
                break;
            default:
                reportType = "全部";
                break;
        }

        helper
                .setText(R.id.tv_type, breakType)
                .setText(R.id.tv_time, simpleDateFormat.format(item.getBreakTime()))
                .setText(R.id.tv_status, reportType);


    }
}
