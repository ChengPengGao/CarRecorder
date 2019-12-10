package com.cf.carrecorder.ui.mine.car.addcar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.utils.FragmentSwitcher;
import com.cf.carrecorder.utils.ToastUtil;
import com.goyourfly.multi_picture.ImageLoader;
import com.goyourfly.multi_picture.MultiPictureView;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 添加车辆
 *
 * @author chenxihu
 * @date 2019-12-10
 * @email androidhcx@163.com
 **/
public class AddCarFragment extends BaseFragment<AddCarView, AddCarPresenter> implements AddCarView {
    private static AddCarFragment instance;

    /**
     * 车辆
     */
    @BindView(R.id.mpv_car)
    MultiPictureView mpvCar;

    /**
     * 行驶证
     */
    @BindView(R.id.mpv_drivingLicense)
    MultiPictureView mpvDrivingLicense;

    /**
     * 驾驶证
     */
    @BindView(R.id.mpv_driverLicense)
    MultiPictureView mpvDriverLicense;

    private List<Uri> carPics;
    private List<Uri> drivingPics;
    private List<Uri> driverPics;

    private final int CODE_CAR = 1;
    private final int CODE_DRIVING = 2;
    private final int CODE_DRIVER = 3;

    public static BaseFragment getInstance() {
        if (instance == null) {
            instance = new AddCarFragment();
        }
        return instance;

    }

    @Override
    protected void initView(View view) {
        MultiPictureView.setImageLoader((ImageLoader) (imageView, uri) -> Glide.with(getActivity())
                .load(uri)
                .into(imageView));

        mpvCar.setAddClickCallback(view1 -> {
            Matisse.from(this)
                    .choose(MimeType.ofAll())
                    .countable(true)
                    .maxSelectable(9)
                    .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                    .thumbnailScale(0.85f)
                    .imageEngine(new GlideEngine())
                    .forResult(CODE_CAR);
        });

        mpvDrivingLicense.setAddClickCallback(view1 -> {
            Matisse.from(this)
                    .choose(MimeType.ofAll())
                    .countable(true)
                    .maxSelectable(9)
                    .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                    .thumbnailScale(0.85f)
                    .imageEngine(new GlideEngine())
                    .forResult(CODE_DRIVING);
        });

        mpvDriverLicense.setAddClickCallback(view1 -> {
            Matisse.from(this)
                    .choose(MimeType.ofAll())
                    .countable(true)
                    .maxSelectable(9)
                    .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                    .thumbnailScale(0.85f)
                    .imageEngine(new GlideEngine())
                    .forResult(CODE_DRIVER);
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CODE_CAR:
                carPics = Matisse.obtainResult(data);
                mpvCar.setList(carPics);
                break;
            case CODE_DRIVING:
                drivingPics = Matisse.obtainResult(data);
                mpvDrivingLicense.setList(drivingPics);
                break;
            case CODE_DRIVER:
                driverPics = Matisse.obtainResult(data);
                mpvDriverLicense.setList(driverPics);
                break;
            default:
                break;
        }

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_addcar;
    }

    @Override
    protected AddCarPresenter initPresenter() {
        return new AddCarPresenter();
    }

    @OnClick({R.id.iv_back,R.id.btn_save})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                back();
                break;
            case R.id.btn_save:
                ToastUtil.show("保存成功");
                break;
            default:
                break;
        }
    }
}
