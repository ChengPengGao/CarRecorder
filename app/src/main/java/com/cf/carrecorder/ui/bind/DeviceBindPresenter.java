package com.cf.carrecorder.ui.bind;

import android.text.TextUtils;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.HttpResult;
import com.cf.carrecorder.bean.RxSubscriber;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.event.CarRecorderEvent;
import com.cf.carrecorder.net.api.CarRecorderApi;
import com.cf.carrecorder.utils.SyncUtil;
import com.cf.carrecorder.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author chenxihu
 * @date 2019-11-27
 * @email androidhcx@163.com
 **/
public class DeviceBindPresenter extends BaseFragmentPresenter {

    DeviceBindView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (DeviceBindView) frgView;
    }

    /**
     * 绑定设备
     * @param deviceKey
     * @param alias
     * @param recCode
     */
    public void loadBind(String deviceKey, String alias, String recCode) {
        if(TextUtils.isEmpty(deviceKey)){
            ToastUtil.show("设备序列号不能为空");
            return;
        }

        if(TextUtils.isEmpty(alias)){
            ToastUtil.show("设备别名不能为空");
            return;
        }

        if(TextUtils.isEmpty(recCode)){
            ToastUtil.show("设备识别码不能为空");
            return;
        }

        CarRecorderApi.bind(GlobalConfig.userId,deviceKey,alias,recCode)
                .subscribeOn(Schedulers.from(CarRecorderApi.service))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifeCycleCarrier)
                .subscribe(new RxSubscriber<HttpResult>() {
                    @Override
                    protected void onSuccess(HttpResult result) {
                        if("0".equals(result.getCode())){
                            SyncUtil.setIsBinded(true);
                            EventBus.getDefault().post(new CarRecorderEvent(CarRecorderEvent.BIND));
                            v.back();
                        }
                        ToastUtil.show(result.getMsg());
                    }

                    @Override
                    protected void onFailure(String errorMsg) {
                        ToastUtil.show(errorMsg);
                    }
                });


    }
}
