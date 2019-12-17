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


    public void loadGridData() {

        RecordListBean recordListBean = new RecordListBean();
        recordListBean.setDeviceNo("666");
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
                        } else {

                            List<RecordListData.RowsBean> datas = new ArrayList<>();



                            for (int i = 0; i < 10; i++) {
                                RecordListData.RowsBean rowsBean = new RecordListData.RowsBean();
                                rowsBean.setId(i);
                                rowsBean.setCarNo("浙A 12345");
                                rowsBean.setUploadTime((int) System.currentTimeMillis());
                                rowsBean.setPhotoUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575968901049&di=6f6974d5386445e5d8461a5a2144565d&imgtype=0&src=http%3A%2F%2Fpic1.16pic.com%2F00%2F07%2F85%2F16pic_785034_b.jpg");
                                datas.add(rowsBean);
                            }

                            RecordListData.RowsBean rowsBean = new RecordListData.RowsBean();
                            rowsBean.setId(10);
                            rowsBean.setCarNo("浙A 12345");
                            rowsBean.setUploadTime((int) System.currentTimeMillis());
                            rowsBean.setPhotoUrl("http://img0.imgtn.bdimg.com/it/u=2295531968,2229594038&fm=26&gp=0.jpg");
                            datas.add(rowsBean);


                            RecordListData.RowsBean rowsBean1 = new RecordListData.RowsBean();
                            rowsBean.setId(11);
                            rowsBean1.setCarNo("浙A 12345");
                            rowsBean1.setUploadTime((int) System.currentTimeMillis());
                            rowsBean1.setPhotoUrl("http://img0.imgtn.bdimg.com/it/u=114125295,3101929527&fm=26&gp=0.jpg");
                            datas.add(rowsBean1);



                            RecordListData.RowsBean rowsBean2 = new RecordListData.RowsBean();
                            rowsBean.setId(12);
                            rowsBean2.setCarNo("浙A 12345");
                            rowsBean2.setUploadTime((int) System.currentTimeMillis());
                            rowsBean2.setPhotoUrl("http://img5.imgtn.bdimg.com/it/u=2687924329,1885072214&fm=26&gp=0.jpg");
                            datas.add(rowsBean2);
                            v.showGridData(datas);
                        }


                    }

                    @Override
                    protected void onFailure(String errorMsg) {
                        ToastUtil.show(errorMsg);
                        Log.e("load recordList", errorMsg);
                    }
                });


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
        for(RecordListData.RowsBean data : selectedData){
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
                        Log.i("load addCollection",result.toString());
                        if("0".equals(result.getCode())){
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
        for(RecordListData.RowsBean data : selectedData){
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
                        Log.i("load addCollection",result.toString());
                        if("0".equals(result.getCode())){

                        }
                        ToastUtil.show(result.getMsg());
                    }

                    @Override
                    protected void onFailure(String errorMsg) {

                        Log.i("load addCollection",errorMsg);
                        ToastUtil.show(errorMsg);
                    }
                });


    }

}
