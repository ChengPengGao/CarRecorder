package com.cf.carrecorder.adapter;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.ButterKnife;

/**
 * @author chenxihu
 * @date 2019-11-27
 * @email androidhcx@163.com
 **/
public abstract class  ViewHolder extends  RecyclerView.ViewHolder{

    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);

    }

    @Nullable
    public final View findViewById(@IdRes int id) {
        return itemView.findViewById(id);
    }

}
