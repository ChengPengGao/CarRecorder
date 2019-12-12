package com.cf.carrecorder.adapter.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Marker;
import com.bumptech.glide.Glide;
import com.cf.carrecorder.R;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * @author chengpenggao
 * @date 2019/12/11
 */
public class InfoWinAdapter implements AMap.InfoWindowAdapter {

    private Context mContext;
    private OnItemButtonClick mOnItemButtonClick;
    private AppCompatImageView imageView;
    private String title, snippet;

    public InfoWinAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view = initView();
        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {

        return null;
    }

    private View initView() {
        View infoWindow = LayoutInflater.from( mContext ).inflate( R.layout.item_map_infowindows, null );
        imageView = infoWindow.findViewById( R.id.iv_info_window );
        imageView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemButtonClick.onButtonClick( view );
            }
        } );
        return infoWindow;
    }

    public void initData(Marker marker) {
        title = marker.getTitle();
        snippet = marker.getSnippet();
    }

    public void setImageView(String id) {
        Glide.with( mContext ).load( id ).into( imageView );
    }

    /**
     * 设置点击事件
     *
     * @param onItemButtonClick
     */
    public void setOnItemButtonClick(OnItemButtonClick onItemButtonClick) {
        this.mOnItemButtonClick = onItemButtonClick;
    }

    /**
     * 点击事件接口
     */
    public interface OnItemButtonClick {

        /**
         * 点击事件
         *
         * @param view
         * @return
         */
        boolean onButtonClick(View view);
    }
}
