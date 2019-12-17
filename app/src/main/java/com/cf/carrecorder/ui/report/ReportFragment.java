package com.cf.carrecorder.ui.report;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cf.carrecorder.R;
import com.cf.carrecorder.app.CarRecorderContext;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.bean.Item;
import com.cf.carrecorder.ui.regist.RegistFragment;
import com.cf.carrecorder.utils.ListUtil;
import com.cf.carrecorder.utils.TypeSafer;
import com.goyourfly.multi_picture.ImageLoader;
import com.goyourfly.multi_picture.MultiPictureView;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import top.defaults.view.DateTimePickerView;
import top.defaults.view.PickerView;

/**
 * 违章举报
 *
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class ReportFragment extends BaseFragment<ReportView, ReportPresenter> implements ReportView {

    private static ReportFragment instance;
    /**
     * 违章类型
     */
    @BindView(R.id.tv_breakType)
    TextView tvBreakType;

    /**
     * 违章行为
     */
    @BindView(R.id.et_detailed)
    EditText etDetailed;

    /**
     * 违章时间
     */
    @BindView(R.id.tv_breakTime)
    TextView tvBreakTime;

    /**
     * 违章地点
     */
    @BindView(R.id.et_address)
    EditText etAddress;

    /**
     * 车辆类型
     */
    @BindView(R.id.tv_carType)
    TextView tvCarType;

    /**
     * 车牌号码
     */
    @BindView(R.id.et_carNo)
    EditText etCarNo;

    /**
     * 举报人姓名
     */
    @BindView(R.id.et_reportUser)
    EditText etReportUser;

    /**
     * 身份证号码
     */
    @BindView(R.id.et_reportIdCard)
    EditText etReportIdCard;

    /**
     * 手机号
     */
    @BindView(R.id.et_reportPhone)
    EditText etReportPhone;

    @BindView(R.id.mpv)
    MultiPictureView mpv;

    private List<Uri> pics;

    private final int CODE_PICS = 1;

    @BindView(R.id.pv_type)
    PickerView pvType;

    @BindView(R.id.pv_carType)
    PickerView pvCarType;

    @BindView(R.id.datePickerView)
    DateTimePickerView dateTimePickerView;

    private long breakTime = 0;

    private int breakType = 0;

    private int carType = 0;

    public ReportFragment() {

    }

    public ReportFragment(List<String> netPics) {
        List<Uri> uris = new ArrayList<>();
        for (int i = 0; i < netPics.size(); i++) {
            uris.add(Uri.parse(netPics.get(i)));
        }
        pics = uris;
    }


    @Override
    protected void initView(View view) {
        MultiPictureView.setImageLoader((ImageLoader) (imageView, uri) -> {
            Glide.with(getActivity())
                    .load(uri)
                    .into(imageView);
        });

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


        pvType.setItems(Item.getTypeItems(), item -> {
            breakType = item.getValue();
            TypeSafer.text(tvBreakType, item.getText());
        });

        pvCarType.setItems(Item.getCarTypeItems(), item -> {
            carType = item.getValue();
            TypeSafer.text(tvCarType, item.getText());
        });

        dateTimePickerView.setOnSelectedDateChangedListener(date -> {
            int year = date.get(Calendar.YEAR);
            int month = date.get(Calendar.MONTH);
            int dayOfMonth = date.get(Calendar.DAY_OF_MONTH);
            int hour = date.get(Calendar.HOUR_OF_DAY);
            int minute = date.get(Calendar.MINUTE);
            breakTime = date.getTimeInMillis();
            String dateString = String.format(Locale.getDefault(), "%d年%02d月%02d日%02d时%02d分", year, month + 1, dayOfMonth, hour, minute);
            TypeSafer.text(tvBreakTime, dateString);
        });


        if(!ListUtil.isEmpty(pics)){
            mpv.setList(pics);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CODE_PICS:

                Log.i("asd",pics.toString());
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

    @OnClick({R.id.iv_back, R.id.btn_save, R.id.tv_breakType, R.id.tv_carType, R.id.tv_breakTime, R.id.et_reportPhone, R.id.et_reportIdCard, R.id.et_reportUser})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                hideAllPickView();
                back();
                break;
            case R.id.btn_save:
                hideAllPickView();
                hideSoftInput();
                presenter.report(
                        etCarNo.getText().toString(),
                        etAddress.getText().toString(),
                        breakType,
                        breakTime,
                        carType,
                        etReportUser.getText().toString(),
                        etReportIdCard.getText().toString(),
                        etReportPhone.getText().toString(),
                        pics);
                break;
            case R.id.tv_breakType:
                hideSoftInput();
                hideAllPickView();
                pvType.setVisibility(View.VISIBLE);

                break;
            case R.id.tv_carType:
                hideSoftInput();
                hideAllPickView();
                pvCarType.setVisibility(View.VISIBLE);

                break;
            case R.id.tv_breakTime:
                hideSoftInput();
                hideAllPickView();
                dateTimePickerView.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }

    }

    @OnFocusChange({
            R.id.et_reportUser,
            R.id.et_reportIdCard,
            R.id.et_reportPhone,
            R.id.et_detailed,
            R.id.et_address,
            R.id.et_carNo})
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {

            hideAllPickView();
        }
    }

    @Override
    public void hideAllPickView() {
        pvCarType.setVisibility(View.GONE);
        pvType.setVisibility(View.GONE);
        dateTimePickerView.setVisibility(View.GONE);
    }
}
