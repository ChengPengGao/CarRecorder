package com.cf.carrecorder.ui.bind;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 绑定设备
 * @author chenxihu
 * @date 2019-11-27
 * @email androidhcx@163.com
 **/
public class DeviceBindFragment extends BaseFragment<DeviceBindView,DeviceBindPresenter> implements DeviceBindView {

    private static DeviceBindFragment instance;

    /**
     * 设备序列号
     */
    @BindView(R.id.et_deviceKey)
    EditText etDeviceKey;

    /**
     * 设备别名
     */
    @BindView(R.id.et_alias)
    EditText etAlias;

    /**
     * 设备识别码
     */
    @BindView(R.id.et_recCode)
    EditText etRecCode;

    public static DeviceBindFragment getInstance() {
        if (instance == null) {
            instance = new DeviceBindFragment();
        }

        return instance;
    }
    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_devicebind;
    }

    @Override
    protected DeviceBindPresenter initPresenter() {
        return new DeviceBindPresenter();
    }

    @OnClick({R.id.iv_back,R.id.btn_save})
    public void onClickBack(View view){
        switch (view.getId()){
            case R.id.iv_back:
                back();
                break;
            case R.id.btn_save:
                presenter.loadBind(etDeviceKey.getText().toString(),etAlias.getText().toString(),etRecCode.getText().toString());
                break;

            default:
                break;
        }
    }
}
