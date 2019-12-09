package com.cf.carrecorder.ui.mine.reported.item;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class ItemPresenter extends BaseFragmentPresenter {
    ItemView v;
    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (ItemView) frgView;
    }
}
