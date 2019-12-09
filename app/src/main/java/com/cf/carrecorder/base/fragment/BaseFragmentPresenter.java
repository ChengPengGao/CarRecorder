package com.cf.carrecorder.base.fragment;

import com.cf.carrecorder.bean.GridBean;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chenxihu
 * @date 2019-11-13
 * @email androidhcx@163.com
 **/
public abstract class BaseFragmentPresenter<T extends BaseFragmentView> {


    /**
     * lifeCycler
     */
    public LifecycleTransformer lifeCycleCarrier;

    public T mView;


    /**
     * frag -- onResume方法执行
     *
     * @param mView
     */
    public void attach(T mView) {
        this.mView = mView;
    }

    /**
     * frag -- onDettach方法执行
     */
    public void dettach() {
        mView = null;
    }

    /**
     * 绑定View
     *
     * @param frgView
     */
    protected abstract void attachView(BaseFragmentView frgView);

    void setLifecycleTransformer(LifecycleTransformer lifeCycleCarrier) {
        this.lifeCycleCarrier = lifeCycleCarrier;
    }

}
