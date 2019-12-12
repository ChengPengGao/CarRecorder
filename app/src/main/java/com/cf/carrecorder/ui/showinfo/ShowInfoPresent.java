package com.cf.carrecorder.ui.showinfo;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;

/**
 * @author chengpenggao
 * @date 2019/12/11
 */
public class ShowInfoPresent extends BaseFragmentPresenter {
    ShowInfoView showInfoView;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.showInfoView = (ShowInfoView) frgView;
    }
}
