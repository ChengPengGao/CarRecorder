package com.cf.carrecorder.ui.report;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.HttpResult;
import com.cf.carrecorder.bean.RxSubscriber;
import com.cf.carrecorder.bean.request.ReportBean;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.net.api.CarRecorderApi;
import com.cf.carrecorder.utils.ListUtil;
import com.cf.carrecorder.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class ReportPresenter extends BaseFragmentPresenter {
    @Override
    protected void attachView(BaseFragmentView frgView) {

    }

    public void report(String carNo, String address, int breakType, long breakTime, int carType, String reportUser, String reportIdCard, String reportPhone, List<Uri> pics) {
        if(TextUtils.isEmpty(carNo)){
            ToastUtil.show("车牌号码不能为空");
            return;
        }

        if(TextUtils.isEmpty(address)){
            ToastUtil.show("违章地点不能为空");
            return;
        }

        if(breakType == 0){
            ToastUtil.show("请选择违章类型");
            return;
        }

        if(breakTime == 0){
            ToastUtil.show("请选择违章时间");
            return;
        }

        if(carType == 0){
            ToastUtil.show("请选择车辆类型");
            return;
        }

        if(TextUtils.isEmpty(reportUser)){
            ToastUtil.show("举报人姓名不能为空");
            return;
        }

        if(TextUtils.isEmpty(reportIdCard)){
            ToastUtil.show("身份证号码不能为空");
            return;
        }

        if(TextUtils.isEmpty(reportPhone)){
            ToastUtil.show("手机号码不能为空");
            return;
        }

        if(ListUtil.isEmpty(pics)){
            ToastUtil.show("请上传举报证据");
            return;
        }


        ReportBean reportBean = new ReportBean();
        reportBean.setAddress(address);
        reportBean.setBreakTime(breakTime);
        reportBean.setBreakType(breakType);
        reportBean.setCarType(carType);
        reportBean.setCarNo(carNo);
        reportBean.setReportUser(reportUser);
        reportBean.setReportIdcard(reportIdCard);
        reportBean.setReportPhone(reportPhone);
        reportBean.setReportType(2);
        reportBean.setUserId(GlobalConfig.userId);
        Log.i("asd",GlobalConfig.userId + "/");
        List<String> photoList = new ArrayList<>();
        photoList.add("http://img4.imgtn.bdimg.com/it/u=1544922432,3408838646&fm=26&gp=0.jpg");
        reportBean.setPhotoList(photoList);

        CarRecorderApi.report(reportBean)
                .subscribeOn(Schedulers.from(CarRecorderApi.service))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifeCycleCarrier)
                .subscribe(new RxSubscriber<HttpResult>() {
                    @Override
                    protected void onSuccess(HttpResult result) {
                        ToastUtil.show(result.getMsg());
                    }

                    @Override
                    protected void onFailure(String errorMsg) {
                        ToastUtil.show(errorMsg);
                    }
                });
    }
}
