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
import com.cf.carrecorder.event.CarRecorderEvent;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;

/**
 * @author chenxihu
 * @date 2019-11-27
 * @email androidhcx@163.com
 **/
public class GirdAdapter extends BaseQuickAdapter<RecordListData.RowsBean, BaseViewHolder> {

    public boolean isSelectMode = false;
    private Context context;

    List<RecordListData.RowsBean> selectedData = new ArrayList<>();

    public GirdAdapter(@Nullable List<RecordListData.RowsBean> data, Context context) {
        super(R.layout.item_grid, data);
        this.context = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, RecordListData.RowsBean item) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        helper
                .setText(R.id.tv_time, simpleDateFormat.format(item.getUploadTime()))
                .setText(R.id.tv_code, item.getCarNo())
                .setText(R.id.tv_exponent, item.getExponent() + "")
                .setBackgroundRes(R.id.tv_exponent, item.getBreakSatus() == 0 ? R.drawable.sp_exponent_qualified : R.drawable.sp_exponent_unqualified)
                .setVisible(R.id.cb, isSelectMode)
                .setOnCheckedChangeListener(R.id.cb, (buttonView, isChecked) -> {
                    if (isChecked) {
                        selectedData.add(item);
                    } else {
                        selectedData.remove(item);
                    }
                    EventBus.getDefault().post(new CarRecorderEvent(CarRecorderEvent.SELECT));
                });
        Glide.with(context)
                .load(item.getPhotoUrl())
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

    public List<RecordListData.RowsBean> getSelectedData() {
        return selectedData;
    }
}
