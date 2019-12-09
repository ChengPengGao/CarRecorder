package com.cf.carrecorder.ui.about;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class AboutPresenter extends BaseFragmentPresenter {

    AboutView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (AboutView) frgView;
    }
}
