package com.cf.carrecorder.adapter.grid;

import android.content.Context;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cf.carrecorder.R;
import com.cf.carrecorder.bean.GridBean;
import com.cf.carrecorder.bean.RecordListData;
import com.cf.carrecorder.bean.RecordListSection;
import com.cf.carrecorder.event.CarRecorderEvent;
import com.cf.carrecorder.utils.SpacesItemDecoration;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.greenrobot.eventbus.EventBus;

/**
 * @author chenxihu
 * @date 2019-11-27
 * @email androidhcx@163.com
 **/
public class GirdAdapter extends BaseSectionQuickAdapter<RecordListSection, BaseViewHolder> {

    public boolean isSelectMode = false;
    private Context context;

    List<RecordListData.RowsBean.DeviceListBean> selectedData = new ArrayList<>();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

    public GirdAdapter(List<RecordListSection> data,Context context) {
        super(R.layout.item_grid, R.layout.item_head, data);
        this.context = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, RecordListSection item) {
        RecordListData.RowsBean.DeviceListBean deviceListBean = item.t;
        helper
                .setText(R.id.tv_time, simpleDateFormat.format(deviceListBean.getUploadTime()))
                .setText(R.id.tv_code, deviceListBean.getCarNo())
                .setText(R.id.tv_exponent, deviceListBean.getExponent() + "")
                .setBackgroundRes(R.id.tv_exponent, deviceListBean.getBreakSatus() == 0 ? R.drawable.sp_exponent_qualified : R.drawable.sp_exponent_unqualified)
                .setVisible(R.id.cb, isSelectMode)
                .setOnCheckedChangeListener(R.id.cb, (buttonView, isChecked) -> {
                    if (isChecked) {
                        selectedData.add(deviceListBean);
                    } else {
                        selectedData.remove(deviceListBean);
                    }
                    EventBus.getDefault().post(new CarRecorderEvent(CarRecorderEvent.SELECT));
                });
        Glide.with(context)
                .load(deviceListBean.getPhotoUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into((ImageView) helper.getView(R.id.iv_record));


    }

    public void changeSelected() {
        isSelectMode = !isSelectMode;
        if (!isSelectMode) {
            selectedData.clear();
        }
        notifyDataSetChanged();
    }

    public List<RecordListData.RowsBean.DeviceListBean> getSelectedData() {
        return selectedData;
    }

    @Override
    protected void convertHead(BaseViewHolder helper, RecordListSection item) {
        helper
                .setText(R.id.tv_time,item.header);
    }
}
