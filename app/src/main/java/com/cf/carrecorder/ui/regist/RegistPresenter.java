package com.cf.carrecorder.ui.regist;

import android.text.TextUtils;
import android.util.Log;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.HttpResult;
import com.cf.carrecorder.bean.RxSubscriber;
import com.cf.carrecorder.net.api.CarRecorderApi;
import com.cf.carrecorder.utils.ToastUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class RegistPresenter extends BaseFragmentPresenter {

    RegistView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (RegistView) frgView;
    }

    public void loadRegist(String phone, String pwd,String pwdConfirm,String captcha) {
        if(TextUtils.isEmpty(phone)){
            ToastUtil.show("电话号码不能为空");
            return;
        }

        if(TextUtils.isEmpty(pwd)){
            ToastUtil.show("密码不能为空");
            return;
        }

        if(TextUtils.isEmpty(pwdConfirm)){
            ToastUtil.show("密码不能为空");
            return;
        }

        if(!pwdConfirm.equals(pwd)){
            ToastUtil.show("两次输入密码不一致");
            return;
        }

        if(TextUtils.isEmpty(captcha)){
            ToastUtil.show("验证码不能为空");
            return;
        }

        CarRecorderApi.register("hcx",phone,pwd,captcha)
                .subscribeOn(Schedulers.from(CarRecorderApi.service))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifeCycleCarrier)
                .subscribe(new RxSubscriber<HttpResult>() {
                    @Override
                    protected void onSuccess(HttpResult result) {
                        Log.i("load regist",  result.toString());
                        if("0".equals(result.getCode())){
                            v.back();
                        }
                        ToastUtil.show(result.getMsg());

                    }

                    @Override
                    protected void onFailure(String errorMsg) {
                        Log.e("load regist",  errorMsg);
                        ToastUtil.show(errorMsg);
                    }
                });

    }

    public void loadSendCode(String phone) {
        if(TextUtils.isEmpty(phone)){
            ToastUtil.show("电话号码不能为空");
            return;
        }

        CarRecorderApi.sendCode(phone)
                .subscribeOn(Schedulers.from(CarRecorderApi.service))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifeCycleCarrier)
                .subscribe(new RxSubscriber<HttpResult>() {
                    @Override
                    protected void onSuccess(HttpResult result) {
                        Log.i("loadSendCode",result.toString());
                        if("0".equals(result.getCode())){

                        }

                        ToastUtil.show(result.getMsg());
                    }

                    @Override
                    protected void onFailure(String errorMsg) {
                        Log.e("loadSendCode",errorMsg);
                        ToastUtil.show(errorMsg);
                    }
                });
    }
}
