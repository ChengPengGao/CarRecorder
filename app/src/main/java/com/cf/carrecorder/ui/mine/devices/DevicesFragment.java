package com.cf.carrecorder.ui.mine.devices;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cf.carrecorder.R;
import com.cf.carrecorder.adapter.devices.DevicesAdapter;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.bean.DevicesBean;
import com.cf.carrecorder.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的设备
 *
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class DevicesFragment extends BaseFragment<DevicesView, DevicesPresenter> implements DevicesView {

    private static DevicesFragment instance;

    public static DevicesFragment getInstance() {
        if (instance == null) {
            instance = new DevicesFragment();
        }
        return instance;
    }

    @BindView(R.id.rv)
    RecyclerView rv;

    DevicesAdapter adapter;

    List<DevicesBean> datas;

    @Override
    protected void initView(View view) {
        datas = new ArrayList<>();
        adapter = new DevicesAdapter(datas);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new SpacesItemDecoration(5));
        presenter.loadDevicesData();
    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_devices;
    }

    @Override
    protected DevicesPresenter initPresenter() {
        return new DevicesPresenter();
    }


    @OnClick(R.id.iv_back)
    public void onClick(View view) {
        back();
    }

    @Override
    public void showDevicesData(List<DevicesBean> devicesBeans) {
        datas.clear();
        datas.addAll(devicesBeans);
        adapter.notifyDataSetChanged();
    }
}
