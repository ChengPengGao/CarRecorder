package com.cf.carrecorder.ui.mine.car;

import android.view.View;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.ui.mine.car.addcar.AddCarFragment;
import com.cf.carrecorder.utils.FragmentSwitcher;

import butterknife.OnClick;

/**
 * 我的车辆
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class CarFragment  extends BaseFragment<CarView,CarPresenter> implements  CarView {

    private static CarFragment instance;

    public static CarFragment getInstance(){
        if(instance == null){
            instance = new CarFragment();
        }
        return instance;
    }
    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_car;
    }

    @Override
    protected CarPresenter initPresenter() {
        return new CarPresenter();
    }

    @OnClick({R.id.iv_back,R.id.tv_add})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                back();
                break;
            case R.id.tv_add:
                FragmentSwitcher.replaceFragment(AddCarFragment.getInstance());
                break;
                default:
                    break;
        }
    }
}
