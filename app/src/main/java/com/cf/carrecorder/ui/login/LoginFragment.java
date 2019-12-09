package com.cf.carrecorder.ui.login;

import android.view.View;
import android.widget.EditText;

import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.ui.foorprint.FootPrintFragment;
import com.cf.carrecorder.ui.report.ReportFragment;
import com.cf.carrecorder.utils.FragmentSwitcher;
import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.ui.regist.RegistFragment;
import com.cf.carrecorder.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author chenxihu
 * @date 2019-11-27
 * @email androidhcx@163.com
 **/
public class LoginFragment extends BaseFragment<LoginView, LoginPresenter> implements LoginView {

    private static LoginFragment instance;

    @BindView(R.id.et_phone)
    EditText etPhone;

    @BindView(R.id.et_pwd)
    EditText etPwd;


    public static LoginFragment getInstance() {
        if (instance == null) {
            instance = new LoginFragment();
        }

        return instance;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_login;
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @OnClick({R.id.tv_regist,R.id.btn_save,R.id.tv_footPrint,R.id.iv_add})
    public void onClick(View view) {
        switch (view.getId()) {
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
            case R.id.tv_regist:
                FragmentSwitcher.replaceFragment(RegistFragment.getInstance());
                break;
            case R.id.btn_save:
                //TODO 登录
                presenter.loadLogin(etPhone.getText().toString(),etPwd.getText().toString());
                break;
            default:
                break;
        }
    }

}
