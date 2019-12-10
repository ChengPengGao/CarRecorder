package com.cf.carrecorder.ui.mine.car.addcar;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;

/**
 * @author chenxihu
 * @date 2019-12-10
 * @email androidhcx@163.com
 **/
public class AddCarPresenter extends BaseFragmentPresenter {

    AddCarView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (AddCarView) frgView;
    }
}
