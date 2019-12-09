package com.cf.carrecorder.ui.mine;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cf.carrecorder.R;
import com.cf.carrecorder.app.InitManager;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.event.CarRecorderEvent;
import com.cf.carrecorder.ui.about.AboutFragment;
import com.cf.carrecorder.ui.bind.DeviceBindFragment;
import com.cf.carrecorder.ui.foorprint.FootPrintFragment;
import com.cf.carrecorder.ui.mine.car.CarFragment;
import com.cf.carrecorder.ui.mine.devices.DevicesFragment;
import com.cf.carrecorder.ui.mine.feedback.FeedbackFragment;
import com.cf.carrecorder.ui.report.ReportFragment;
import com.cf.carrecorder.ui.mine.reported.ReportedFragment;
import com.cf.carrecorder.utils.FragmentSwitcher;
import com.cf.carrecorder.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author chenxihu
 * @date 2019-11-18
 * @email androidhcx@163.com
 **/
public class MineFragment extends BaseFragment<MineView, MinePresenter> implements MineView {

    private static MineFragment instance;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.ll_add)
    LinearLayout llAdd;

    public static MineFragment getInstance() {
        if (instance == null) {
            instance = new MineFragment();
        }

        return instance;
    }

    @Override
    protected void initView(View view) {
        showBottomBar();
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

    @OnClick({R.id.tv_footPrint,
            R.id.iv_add,
            R.id.rl_about,
            R.id.ll_all,
            R.id.tv_bottom_report,
            R.id.tv_bottom_bind,
            R.id.btn_exit,
            R.id.tv_reported,
            R.id.tv_devices,
            R.id.rl_car,
            R.id.rl_feedback})
    protected void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_footPrint:
                FragmentSwitcher.replaceUnAddToBackStackFragment(FootPrintFragment.getInstance());
                break;
            case R.id.iv_add:
                showAddBar();
                break;

            case R.id.ll_add:
                showBottomBar();
                break;
            case R.id.tv_bottom_report:
                if (!GlobalConfig.isLogined) {
                    ToastUtil.show("请先登录");
                    return;
                }
                FragmentSwitcher.replaceFragment(ReportFragment.getInstance());
                break;
            case R.id.tv_bottom_bind:
                if (!GlobalConfig.isLogined) {
                    ToastUtil.show("请先登录");
                    return;
                }
                FragmentSwitcher.replaceFragment(DeviceBindFragment.getInstance());
                break;
            case R.id.ll_all:
                showBottomBar();
                break;
            case R.id.rl_about:
                FragmentSwitcher.replaceFragment(AboutFragment.getInstance());
                break;
            case R.id.rl_car:
                FragmentSwitcher.replaceFragment(CarFragment.getInstance());
                break;
            case R.id.rl_feedback:
                FragmentSwitcher.replaceFragment(FeedbackFragment.getInstance());
                break;
            case R.id.btn_exit:
                InitManager.getInstance().logout();
                EventBus.getDefault().post(new CarRecorderEvent(CarRecorderEvent.LOGOUT));
                break;
            case R.id.tv_reported:
                FragmentSwitcher.replaceFragment(ReportedFragment.getInstance());
                break;
            case R.id.tv_devices:
                FragmentSwitcher.replaceFragment(DevicesFragment.getInstance());
                break;

            default:
                break;
        }
    }

    @Override
    public void showBottomBar() {
        llBottom.setVisibility(View.VISIBLE);
        llAdd.setVisibility(View.GONE);
    }

    @Override
    public void showAddBar() {
        llBottom.setVisibility(View.GONE);
        llAdd.setVisibility(View.VISIBLE);
    }
}
