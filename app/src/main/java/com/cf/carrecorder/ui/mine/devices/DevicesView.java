package com.cf.carrecorder.ui.mine.devices;

import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.DevicesBean;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public interface DevicesView extends BaseFragmentView {

    void showDevicesData(List<DevicesBean> devicesBeans);

}
