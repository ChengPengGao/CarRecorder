package com.cf.carrecorder.ui.mine;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;

/**
 * @author chenxihu
 * @date 2019-11-18
 * @email androidhcx@163.com
 **/
public class MinePresenter extends BaseFragmentPresenter {

    MineView v;


    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (MineView) frgView;
    }
}
