package com.cf.carrecorder.ui.regist;

import android.view.View;
import android.widget.EditText;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.ui.login.LoginFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class RegistFragment extends BaseFragment<RegistView, RegistPresenter> implements RegistView {

    private static RegistFragment instance;

    @BindView(R.id.et_phone)
    EditText etPhone;

    @BindView(R.id.et_pwd)
    EditText etPwd;

    @BindView(R.id.et_confirm)
    EditText etConfirm;

    @BindView(R.id.et_verifyCode)
    EditText etVerifyCode;

    public static RegistFragment getInstance() {
        if (instance == null) {
            instance = new RegistFragment();
        }

        return instance;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_regist;
    }

    @Override
    protected RegistPresenter initPresenter() {
        return new RegistPresenter();
    }

    @OnClick({R.id.btn_save,R.id.tv_getCode,R.id.iv_close})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                presenter.loadRegist(etPhone.getText().toString(),etPwd.getText().toString(),etConfirm.getText().toString(),etVerifyCode.getText().toString());
                break;
            case R.id.tv_getCode:
                presenter.loadSendCode(etPhone.getText().toString());
                break;
            case R.id.iv_close:
                back();
                break;
            default:
                break;
        }
    }
}
