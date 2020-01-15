package com.cf.carrecorder.ui.showinfo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.bean.RecordListData;

import java.util.List;

import butterknife.BindView;

/**
 * @author chengpenggao
 * @date 2019/12/11
 */
public class ShowInfoFragment extends BaseFragment<ShowInfoView, ShowInfoPresent> implements ShowInfoView {

    private static ShowInfoFragment instance;
    public static final String KEY_USER_ID = "DATA";
    public static final String KEY_USER_H = "height";
    public static final String KEY_USER_W = "wight";
    private List<RecordListData.RowsBean> datas;

    private String photoUrl;
    private double height;
    private double wight;

    @BindView(R.id.empty_view_content)
    ImageView imageView;


    public static ShowInfoFragment getInstance(RecordListData.RowsBean.DeviceListBean beans) {
        if (instance == null) {
            Bundle args = new Bundle();
            args.putString( KEY_USER_ID, beans.getPhotoUrl() );
            args.putDouble( KEY_USER_H, beans.getLatitude() );
            args.putDouble( KEY_USER_W, beans.getLongitude() );
            instance = new ShowInfoFragment();
            instance.setArguments( args );
        }
        return instance;
    }

    @Override
    protected void initView(View view) {
        if (getArguments() != null) {
            photoUrl = getArguments().getString( KEY_USER_ID );
            height = getArguments().getDouble( KEY_USER_H );
            wight = getArguments().getDouble( KEY_USER_W );
            Glide.with( getActivity() ).load( photoUrl ).fallback( R.mipmap.icon_log ).into( imageView );
        }
    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_showinfo;
    }

    @Override
    protected ShowInfoPresent initPresenter() {
        return new ShowInfoPresent();
    }
}
