package com.cf.carrecorder.ui.mine.reported;

import android.view.View;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;

import butterknife.OnClick;

/**
 * 我的举报
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class ReportedFragment extends BaseFragment<ReportedView,ReportedPresenter> implements  ReportedView {

    private static  ReportedFragment instance;

    public static ReportedFragment getInstance() {
        if (instance == null) {
            instance = new ReportedFragment();
        }

        return instance;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.layout_reported;
    }

    @Override
    protected ReportedPresenter initPresenter() {
        return new ReportedPresenter();
    }


    @OnClick(R.id.iv_back)
    public void onClick(View view){
        back();
    }
}
