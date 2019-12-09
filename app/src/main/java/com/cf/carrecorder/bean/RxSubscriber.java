package com.cf.carrecorder.bean;

import android.app.Dialog;
import android.util.Log;

import io.reactivex.observers.DisposableObserver;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public abstract class RxSubscriber<T> extends DisposableObserver<T> {

    private Dialog dialog;

    public RxSubscriber(){}


    public RxSubscriber(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (dialog != null && !dialog.isShowing()){
            dialog.show();
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onFailure(e.getMessage());
    }

    @Override
    public void onComplete() {
        hideDialog();
    }



    private void hideDialog(){
        if (dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    protected abstract void onSuccess(T result);

    protected abstract void onFailure(String errorMsg);
}
