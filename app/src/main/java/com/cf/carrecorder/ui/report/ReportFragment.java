package com.cf.carrecorder.ui.report;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.ui.regist.RegistFragment;
import com.goyourfly.multi_picture.ImageLoader;
import com.goyourfly.multi_picture.MultiPictureView;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 违章举报
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class ReportFragment extends BaseFragment<ReportView,ReportPresenter> implements ReportView {

    private static  ReportFragment instance;
    /**
     * 违章类型
     */
    @BindView(R.id.et_type)
    EditText etType;

    /**
     * 违章行为
     */
    @BindView(R.id.et_detailed)
    EditText etDetailed;

    /**
     * 违章时间
     */
    @BindView(R.id.et_time)
    EditText etTime;

    /**
     * 违章地点
     */
    @BindView(R.id.et_place)
    EditText etPlace;

    /**
     * 车辆类型
     */
    @BindView(R.id.et_plateType)
    EditText etPlateType;

    /**
     * 车牌号码
     */
    @BindView(R.id.et_plateCode)
    EditText etPlateCode;

    /**
     * 举报人姓名
     */
    @BindView(R.id.et_name)
    EditText etName;

    /**
     * 身份证号码
     */
    @BindView(R.id.et_id)
    EditText etId;

    @BindView(R.id.mpv)
    MultiPictureView mpv;

    private List<Uri> pics;

    private final int CODE_PICS = 1;


    public static ReportFragment getInstance() {
        if (instance == null) {
            instance = new ReportFragment();
        }

        return instance;
    }


    @Override
    protected void initView(View view) {
        MultiPictureView.setImageLoader((ImageLoader) (imageView, uri) -> Glide.with(getActivity())
                .load(uri)
                .into(imageView));

        mpv.setAddClickCallback(view1 -> {
            Matisse.from(this)
                    .choose(MimeType.ofAll())
                    .countable(true)
                    .maxSelectable(9)
                    .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                    .thumbnailScale(0.85f)
                    .imageEngine(new GlideEngine())
                    .forResult(CODE_PICS);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CODE_PICS:
                pics = Matisse.obtainResult(data);
                mpv.setList(pics);
                break;
            default:
                break;
        }

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_report;
    }

    @Override
    protected ReportPresenter initPresenter() {
        return new ReportPresenter();
    }

    @OnClick(R.id.iv_back)
    public void onClick(View view){
        back();
    }
}
