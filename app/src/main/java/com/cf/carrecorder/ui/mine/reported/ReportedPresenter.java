package com.cf.carrecorder.ui.mine.reported;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class ReportedPresenter extends BaseFragmentPresenter {

    ReportedView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (ReportedView) frgView;
    }
}
