package com.cf.carrecorder.ui.mine.editpassword;

import android.view.View;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.utils.FragmentSwitcher;

import butterknife.OnClick;

/**
 * 重置密码
 *
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class EditPasswordFragment extends BaseFragment<EditPasswordView, EditPasswordPresenter> implements EditPasswordView {

    private static EditPasswordFragment instance;

    public static EditPasswordFragment getInstance() {
        if (instance == null) {
            instance = new EditPasswordFragment();
        }
        return instance;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.layout_editpassword;
    }

    @Override
    protected EditPasswordPresenter initPresenter() {
        return new EditPasswordPresenter();
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
