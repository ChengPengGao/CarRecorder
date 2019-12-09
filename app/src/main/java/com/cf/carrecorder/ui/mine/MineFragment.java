package com.cf.carrecorder.ui.mine;

import android.view.View;
import android.widget.Toast;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.ui.about.AboutFragment;
import com.cf.carrecorder.ui.bind.DeviceBindFragment;
import com.cf.carrecorder.ui.foorprint.FootPrintFragment;
import com.cf.carrecorder.ui.login.LoginFragment;
import com.cf.carrecorder.ui.report.ReportFragment;
import com.cf.carrecorder.utils.FragmentSwitcher;
import com.cf.carrecorder.utils.ToastUtil;

import butterknife.OnClick;

/**
 * @author chenxihu
 * @date 2019-11-18
 * @email androidhcx@163.com
 **/
public class MineFragment extends BaseFragment<MineView, MinePresenter> implements MineView {

    private static MineFragment instance;

    public static MineFragment getInstance() {
        if (instance == null) {
            instance = new MineFragment();
        }

        return instance;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected MinePresenter initPresenter() {
        return new MinePresenter();
    }

    @OnClick(R.id.rl_user)
    public void onClickUser(View v) {
        Toast.makeText(getActivity(), "人员信息", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.tv_footPrint, R.id.iv_add,R.id.rl_about})
    protected void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_footPrint:
                FragmentSwitcher.replaceUnAddToBackStackFragment(FootPrintFragment.getInstance());
                break;
            case R.id.iv_add:
                if(!GlobalConfig.isLogined){
                    ToastUtil.show("请先登录");
                    return;
                }
                FragmentSwitcher.replaceFragment(ReportFragment.getInstance());
                break;
            case R.id.rl_about:
                FragmentSwitcher.replaceFragment(AboutFragment.getInstance());
                break;
            default:
                break;
        }
    }
}
