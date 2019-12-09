package com.cf.carrecorder.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.cf.carrecorder.utils.FragmentSwitcher;
import com.cf.carrecorder.R;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.event.CarRecorderEvent;
import com.cf.carrecorder.ui.foorprint.FootPrintFragment;
import com.cf.carrecorder.ui.login.LoginFragment;
import com.cf.carrecorder.ui.mine.MineFragment;
import com.cf.carrecorder.ui.report.ReportFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FragmentSwitcher.init(this);
        EventBus.getDefault().register(this);


        initView();

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            GlobalConfig.profit += 0.05f;
            EventBus.getDefault().post(new CarRecorderEvent(CarRecorderEvent.ADD));
        },0,2,TimeUnit.MINUTES);

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(CarRecorderEvent event) {
        Log.i("receiveData", event.getType() + "");
        switch (event.getType()) {
            case CarRecorderEvent.LOGIN:
                FragmentSwitcher.replaceUnAddToBackStackFragment(MineFragment.getInstance());
                hideSoftInput();
                break;
            case CarRecorderEvent.LOGOUT:
                FragmentSwitcher.replaceUnAddToBackStackFragment(LoginFragment.getInstance());
                hideSoftInput();
                break;
            default:
                break;
        }

    }

    private void initView() {
        FragmentSwitcher.replaceUnAddToBackStackFragment(FootPrintFragment.getInstance());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    /**
     * 隐藏软键盘
     */
    private void hideSoftInput() {
        View v = getCurrentFocus();
        if (v != null && v.getWindowToken() != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            boolean isOpen = manager.isActive();
            if (isOpen) {
                manager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

}
