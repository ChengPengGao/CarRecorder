package com.cf.carrecorder.ui.about;

import android.view.View;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.ui.mine.MineFragment;
import com.cf.carrecorder.utils.FragmentSwitcher;

import butterknife.OnClick;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class AboutFragment extends BaseFragment<AboutView, AboutPresenter> implements AboutView {

    private static AboutFragment instance;

    public static AboutFragment getInstance() {
        if (instance == null) {
            instance = new AboutFragment();
        }

        return instance;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_about;
    }

    @Override
    protected AboutPresenter initPresenter() {
        return new AboutPresenter();
    }

    @OnClick(R.id.iv_back)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                FragmentSwitcher.back();
                break;

            default:
                break;
        }
    }
}
