package com.cf.carrecorder.ui.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.HttpResult;
import com.cf.carrecorder.bean.LoginData;
import com.cf.carrecorder.bean.RxSubscriber;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.event.CarRecorderEvent;
import com.cf.carrecorder.net.api.CarRecorderApi;
import com.cf.carrecorder.utils.SPUtil;
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
public class LoginPresenter extends BaseFragmentPresenter {

    LoginView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (LoginView) frgView;
    }

    public void loadLogin(String phone, String pwd) {

        if(TextUtils.isEmpty(phone)){
            ToastUtil.show("电话号码不能为空");
            return;
        }

        if(TextUtils.isEmpty(pwd)){
            ToastUtil.show("密码不能为空");
            return;
        }

        CarRecorderApi.login(phone,pwd)
                .subscribeOn(Schedulers.from(CarRecorderApi.service))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifeCycleCarrier)
                .subscribe(new RxSubscriber<HttpResult<LoginData>>() {

                    @Override
                    protected void onSuccess(HttpResult<LoginData> result) {
                        Log.i("load login",result.toString());
                        if("0".equals(result.getCode())){
                            //登录成功
                            SyncUtil.setUserId(result.getData().getUserId());
                            SyncUtil.setUserPhone(result.getData().getPhone());
                            EventBus.getDefault().post(new CarRecorderEvent(CarRecorderEvent.LOGIN));
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
