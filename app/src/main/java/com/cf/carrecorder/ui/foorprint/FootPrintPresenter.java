package com.cf.carrecorder.ui.foorprint;

import android.graphics.Bitmap;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.cf.carrecorder.app.CarRecorderContext;
import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.GridBean;
import com.cf.carrecorder.bean.HttpResult;
import com.cf.carrecorder.bean.RecordListData;
import com.cf.carrecorder.bean.RxSubscriber;
import com.cf.carrecorder.bean.request.AddConllectionBean;
import com.cf.carrecorder.bean.request.RecordListBean;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.net.api.CarRecorderApi;
import com.cf.carrecorder.utils.BitmapUtil;
import com.cf.carrecorder.utils.ListUtil;
import com.cf.carrecorder.utils.ToastUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author chenxihu
 * @date 2019-11-18
 * @email androidhcx@163.com
 **/
public class FootPrintPresenter extends BaseFragmentPresenter<BaseFragmentView> {

    FootPrintView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (FootPrintView) frgView;
    }


    public void loadGridData(boolean isCollection) {

        RecordListBean recordListBean = new RecordListBean();
        recordListBean.setUserId(GlobalConfig.userId);
        if(isCollection){
            CarRecorderApi.collectionList(recordListBean, 0, 10)
                    .subscribeOn(Schedulers.from(CarRecorderApi.service))
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(lifeCycleCarrier)
                    .subscribe(new RxSubscriber<HttpResult<RecordListData>>() {

                        @Override
                        protected void onSuccess(HttpResult<RecordListData> result) {
                            Log.i("load recordList", result.toString());
                            if (result.getData() != null) {
                                if ("0".equals(result.getCode())) {
                                    v.showGridData(result.getData().getRows());
                                } else {
                                    ToastUtil.show(result.getMsg());
                                }
                            }

                        }

                        @Override
                        protected void onFailure(String errorMsg) {
                            ToastUtil.show(errorMsg);
                            Log.e("load recordList", errorMsg);
                        }
                    });
        }else{
            CarRecorderApi.recordList(recordListBean, 0, 10)
                    .subscribeOn(Schedulers.from(CarRecorderApi.service))
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(lifeCycleCarrier)
                    .subscribe(new RxSubscriber<HttpResult<RecordListData>>() {

                        @Override
                        protected void onSuccess(HttpResult<RecordListData> result) {
                            Log.i("load recordList", result.toString());
                            if (result.getData() != null) {
                                if ("0".equals(result.getCode())) {
                                    v.showGridData(result.getData().getRows());
                                } else {
                                    ToastUtil.show(result.getMsg());
                                }
                            }

                        }

                        @Override
                        protected void onFailure(String errorMsg) {
                            ToastUtil.show(errorMsg);
                            Log.e("load recordList", errorMsg);
                        }
                    });
        }



    }

    public void saveImg(List<RecordListData.RowsBean> selectedData) {
        if (ListUtil.isEmpty(selectedData)) {
            ToastUtil.show("请选择");
            return;
        }

        for (RecordListData.RowsBean rowsBean : selectedData) {
            Glide.with(CarRecorderContext.context).load(rowsBean.getPhotoUrl()).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    BitmapUtil.saveBmp2Gallery(CarRecorderContext.context, resource, "car" + System.currentTimeMillis());
                }
            });

        }
        ToastUtil.show("保存成功");


    }

    public void remove(List<RecordListData.RowsBean> selectedData) {
        if (ListUtil.isEmpty(selectedData)) {
            ToastUtil.show("请选择");
            return;
        }

        AddConllectionBean addConllectionBean = new AddConllectionBean();
        addConllectionBean.setUserId(GlobalConfig.userId);
        List<Integer> ids = new ArrayList<>();
        for (RecordListData.RowsBean data : selectedData) {
            ids.add(data.getId());
        }
        addConllectionBean.setDrivingList(ids);
        CarRecorderApi.deleteConllection(addConllectionBean)
                .subscribeOn(Schedulers.from(CarRecorderApi.service))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifeCycleCarrier)
                .subscribe(new RxSubscriber<HttpResult>() {
                    @Override
                    protected void onSuccess(HttpResult result) {
                        Log.i("load addCollection", result.toString());
                        if ("0".equals(result.getCode())) {
                            v.removeList(ids);
                        }
                        ToastUtil.show(result.getMsg());
                    }

                    @Override
                    protected void onFailure(String errorMsg) {
                        ToastUtil.show(errorMsg);
                    }
                });
    }

    public void collect(List<RecordListData.RowsBean> selectedData) {
        if (ListUtil.isEmpty(selectedData)) {
            ToastUtil.show("请选择");
            return;
        }

        AddConllectionBean addConllectionBean = new AddConllectionBean();
        addConllectionBean.setUserId(GlobalConfig.userId);
        List<Integer> ids = new ArrayList<>();
        for (RecordListData.RowsBean data : selectedData) {
            ids.add(data.getId());
        }
        addConllectionBean.setDrivingList(ids);
        CarRecorderApi.addConllection(addConllectionBean)
                .subscribeOn(Schedulers.from(CarRecorderApi.service))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifeCycleCarrier)
                .subscribe(new RxSubscriber<HttpResult>() {
                    @Override
                    protected void onSuccess(HttpResult result) {
                        Log.i("load addCollection", result.toString());
                        if ("0".equals(result.getCode())) {

                        }
                        ToastUtil.show(result.getMsg());
                    }

                    @Override
                    protected void onFailure(String errorMsg) {

                        Log.i("load addCollection", errorMsg);
                        ToastUtil.show(errorMsg);
                    }
                });


    }

    /**
     * 举报违章
     *
     * @param selectedData
     */
    public void report(List<RecordListData.RowsBean> selectedData) {
        if (ListUtil.isEmpty(selectedData)) {
            ToastUtil.show("请选择");
            return;
        }

        List<String> pics = new ArrayList<>();
        for (int i = 0; i < selectedData.size(); i++) {
            pics.add(selectedData.get(i).getPhotoUrl());
        }

        v.jumpToReport(pics);
    }
}
