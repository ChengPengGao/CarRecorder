package com.cf.carrecorder.adapter.devices;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cf.carrecorder.R;
import com.cf.carrecorder.bean.DevicesBean;
import com.cf.carrecorder.bean.GridBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class DevicesAdapter extends BaseQuickAdapter<DevicesBean, BaseViewHolder> {
    public DevicesAdapter(@Nullable List<DevicesBean> data) {
        super(R.layout.item_devices, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DevicesBean item) {
        helper
                .setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_no, item.getDeviceNo());


    }
}
