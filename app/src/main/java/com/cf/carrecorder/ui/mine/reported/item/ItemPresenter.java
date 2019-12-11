package com.cf.carrecorder.ui.mine.reported.item;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.HttpResult;
import com.cf.carrecorder.bean.ReportListData;
import com.cf.carrecorder.bean.ReportedBean;
import com.cf.carrecorder.bean.RxSubscriber;
import com.cf.carrecorder.bean.request.ReportListBean;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.net.api.CarRecorderApi;
import com.cf.carrecorder.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class ItemPresenter extends BaseFragmentPresenter {
    ItemView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (ItemView) frgView;
    }

    public void loadReportedData(int type,int count) {

        ReportListBean reportListBean = new ReportListBean();
        reportListBean.setUserId(GlobalConfig.userId);
        reportListBean.setAuditStatus(type);

        CarRecorderApi.reportList(reportListBean)
                .subscribeOn(Schedulers.from(CarRecorderApi.service))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifeCycleCarrier)
                .subscribe(new RxSubscriber<String>() {
                    @Override
                    protected void onSuccess(String result) {
                        Log.i("load reported data",result.toString());
                        if(!TextUtils.isEmpty(result)){

                            ReportListData reportListData = JSON.parseObject(result,ReportListData.class);
                            if(reportListData != null){

                                v.showReportedData(reportListData.getRows());
                            }
                        }
                    }

                    @Override
                    protected void onFailure(String errorMsg) {
                        Log.i("load reported data",errorMsg);
                        ToastUtil.show(errorMsg);
                    }
                });
    }
}
