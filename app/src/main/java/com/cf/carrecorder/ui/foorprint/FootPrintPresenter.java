package com.cf.carrecorder.ui.foorprint;

import android.graphics.Bitmap;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.cf.carrecorder.app.CarRecorderContext;
import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.GridBean;
import com.cf.carrecorder.bean.HttpResult;
import com.cf.carrecorder.bean.RecordListData;
import com.cf.carrecorder.bean.RecordListSection;
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

    private int pageNum = 0;
    private int pageSize = 10;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (FootPrintView) frgView;
    }


    public void loadGridData(boolean isCollection,boolean isReset) {
        if(isReset){
            pageNum = 0;
        }

        Log.i("load recordList pageNum",pageNum + "");
        RecordListBean recordListBean = new RecordListBean();
        recordListBean.setUserId(GlobalConfig.userId);
        if(isCollection){
            CarRecorderApi.collectionList(recordListBean, pageNum, pageSize)
                    .subscribeOn(Schedulers.from(CarRecorderApi.service))
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(lifeCycleCarrier)
                    .subscribe(new RxSubscriber<String>() {

                        @Override
                        protected void onSuccess(String result) {
                            Log.i("asd", result.toString());
                            RecordListData data = JSON.parseObject(result,RecordListData.class);
                            if(data.getTotal() / pageSize == 0){
                                v.refreshComplete();
                                if(isReset){
                                    v.clearData();
                                }


                                List<RecordListSection> newDatas = new ArrayList<>();
                                for(int i = 0 ; i < data.getRows().size();i++){
                                    RecordListSection sectionHeader = new RecordListSection(true, data.getRows().get(i).getTime());
                                    newDatas.add(sectionHeader);
                                    if (!ListUtil.isEmpty(data.getRows().get(i).getDeviceList())) {
                                        for (int j = 0; j < data.getRows().get(i).getDeviceList().size(); j++) {
                                            RecordListSection section = new RecordListSection(data.getRows().get(i).getDeviceList().get(j));
                                            newDatas.add(section);
                                        }
                                    }
                                }
                                v.showGridData(newDatas);
                                v.loadMoreEnd();
                            }else{
                                if(data.getTotal() / pageSize  == pageNum){
                                    v.refreshComplete();
                                    v.loadMoreEnd();
                                }else{
                                    if(data != null){
                                        if(isReset){
                                            v.clearData();
                                        }


                                        List<RecordListSection> newDatas = new ArrayList<>();
                                        for(int i = 0 ; i < data.getRows().size();i++){
                                            RecordListSection sectionHeader = new RecordListSection(true, data.getRows().get(i).getTime());
                                            newDatas.add(sectionHeader);
                                            if (!ListUtil.isEmpty(data.getRows().get(i).getDeviceList())) {
                                                for (int j = 0; j < data.getRows().get(i).getDeviceList().size(); j++) {
                                                    RecordListSection section = new RecordListSection(data.getRows().get(i).getDeviceList().get(j));
                                                    newDatas.add(section);
                                                }
                                            }
                                        }
                                        v.showGridData(newDatas);
                                        pageNum++;
                                        v.refreshComplete();
                                        v.loadMoreComplete();
                                    }else{
                                        v.refreshComplete();
                                        v.loadMoreEnd();
                                    }

                                }
                            }




                        }

                        @Override
                        protected void onFailure(String errorMsg) {
                            Log.i("asd", errorMsg);
                            ToastUtil.show(errorMsg);
                            Log.e("load recordList", errorMsg);
                            v.refreshComplete();
                            v.loadMoreComplete();
                        }
                    });
        }else{
            CarRecorderApi.recordList(recordListBean, pageNum, pageSize)
                    .subscribeOn(Schedulers.from(CarRecorderApi.service))
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(lifeCycleCarrier)
                    .subscribe(new RxSubscriber<String>() {

                        @Override
                        protected void onSuccess(String result) {
                            Log.i("asd", result.toString());
                            RecordListData data = JSON.parseObject(result,RecordListData.class);
                            if(data.getTotal() / pageSize == 0){
                                v.refreshComplete();
                                if(isReset){
                                    v.clearData();
                                }
                                List<RecordListSection> newDatas = new ArrayList<>();
                                for(int i = 0 ; i < data.getRows().size();i++){
                                    RecordListSection sectionHeader = new RecordListSection(true, data.getRows().get(i).getTime());
                                    newDatas.add(sectionHeader);
                                    if (!ListUtil.isEmpty(data.getRows().get(i).getDeviceList())) {
                                        for (int j = 0; j < data.getRows().get(i).getDeviceList().size(); j++) {
                                            RecordListSection section = new RecordListSection(data.getRows().get(i).getDeviceList().get(j));
                                            newDatas.add(section);
                                        }
                                    }
                                }
                                v.showGridData(newDatas);
                                v.loadMoreEnd();
                            }else{
                                if(data.getTotal() / pageSize  == pageNum){
                                    v.refreshComplete();
                                    v.loadMoreEnd();
                                }else{
                                    if(data != null){
                                        if(isReset){
                                            v.clearData();
                                        }
                                        List<RecordListSection> newDatas = new ArrayList<>();
                                        for(int i = 0 ; i < data.getRows().size();i++){
                                            RecordListSection sectionHeader = new RecordListSection(true, data.getRows().get(i).getTime());
                                            newDatas.add(sectionHeader);
                                            if (!ListUtil.isEmpty(data.getRows().get(i).getDeviceList())) {
                                                for (int j = 0; j < data.getRows().get(i).getDeviceList().size(); j++) {
                                                    RecordListSection section = new RecordListSection(data.getRows().get(i).getDeviceList().get(j));
                                                    newDatas.add(section);
                                                }
                                            }
                                        }
                                        v.showGridData(newDatas);
                                        pageNum++;
                                        v.refreshComplete();
                                        v.loadMoreComplete();
                                    }else{
                                        v.refreshComplete();
                                        v.loadMoreEnd();
                                    }
                                }

                            }



                        }

                        @Override
                        protected void onFailure(String errorMsg) {
                            ToastUtil.show(errorMsg);
                            Log.e("load recordList", errorMsg);
                            v.refreshComplete();
                            v.loadMoreComplete();
                        }
                    });
        }



    }

    public void saveImg(List<RecordListData.RowsBean.DeviceListBean> selectedData) {
        if (ListUtil.isEmpty(selectedData)) {
            ToastUtil.show("请选择");
            return;
        }

        for (RecordListData.RowsBean.DeviceListBean rowsBean : selectedData) {
            Glide.with(CarRecorderContext.context).load(rowsBean.getPhotoUrl()).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    BitmapUtil.saveBmp2Gallery(CarRecorderContext.context, resource, "car" + System.currentTimeMillis());
                }
            });

        }
        ToastUtil.show("保存成功");


    }

    public void remove(List<RecordListData.RowsBean.DeviceListBean> selectedData) {
        if (ListUtil.isEmpty(selectedData)) {
            ToastUtil.show("请选择");
            return;
        }

        AddConllectionBean addConllectionBean = new AddConllectionBean();
        addConllectionBean.setUserId(GlobalConfig.userId);
        List<Integer> ids = new ArrayList<>();
        for (RecordListData.RowsBean.DeviceListBean data : selectedData) {
            ids.add(data.getId());
        }
        Log.i("remove","remove ids : " + ids.toString());
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

    public void collect(List<RecordListData.RowsBean.DeviceListBean> selectedData) {
        if (ListUtil.isEmpty(selectedData)) {
            ToastUtil.show("请选择");
            return;
        }

        AddConllectionBean addConllectionBean = new AddConllectionBean();
        addConllectionBean.setUserId(GlobalConfig.userId);
        List<Integer> ids = new ArrayList<>();
        for (RecordListData.RowsBean.DeviceListBean data : selectedData) {
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
    public void report(List<RecordListData.RowsBean.DeviceListBean> selectedData) {
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
