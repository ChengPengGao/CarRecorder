package com.cf.carrecorder.ui.mine.reported.item;

import android.view.View;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class ItemFragment extends BaseFragment<ItemView,ItemPresenter> implements ItemView {
    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_reported_item;
    }

    @Override
    protected ItemPresenter initPresenter() {
        return new ItemPresenter();
    }
}
