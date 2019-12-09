package com.cf.carrecorder.ui.mine.devices;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.DevicesBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class DevicesPresenter extends BaseFragmentPresenter {

    DevicesView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (DevicesView) frgView;
    }

    public void loadDevicesData() {
        List<DevicesBean> devicesBeans = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            DevicesBean devicesBean = new DevicesBean();
            devicesBean.setName("行车记录仪" +(i+1) );
            devicesBean.setDeviceNo("23456743" + i);
            devicesBeans.add(devicesBean);
        }

        v.showDevicesData(devicesBeans);
    }
}
