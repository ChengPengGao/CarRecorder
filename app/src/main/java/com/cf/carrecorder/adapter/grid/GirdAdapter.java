package com.cf.carrecorder.adapter.grid;

import android.util.Log;
import android.widget.CompoundButton;

import com.cf.carrecorder.R;
import com.cf.carrecorder.bean.GridBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author chenxihu
 * @date 2019-11-27
 * @email androidhcx@163.com
 **/
public class GirdAdapter extends BaseQuickAdapter<GridBean, BaseViewHolder> {

    public boolean isSelectMode = false;

    List<GridBean> selectedData = new ArrayList<>();

    public GirdAdapter(@Nullable List<GridBean> data) {
        super(R.layout.item_grid, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GridBean item) {
        helper
                .setText(R.id.tv_time, item.getTime())
                .setText(R.id.tv_code, item.getCode())
                .setVisible(R.id.cb,isSelectMode)
                .setOnCheckedChangeListener(R.id.cb, (buttonView, isChecked) -> {
                    if(isChecked){
                        selectedData.add(item);
                    }else{
                        selectedData.remove(item);
                    }
                });




    }

    public void changeSelected() {
        isSelectMode = !isSelectMode;
        if(!isSelectMode){
            selectedData.clear();
        }
        notifyDataSetChanged();
    }
}
