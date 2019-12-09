package com.cf.carrecorder.utils;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.ui.bind.DeviceBindFragment;
import com.cf.carrecorder.ui.login.LoginFragment;
import com.cf.carrecorder.ui.mine.MineFragment;

/**
 * @author chenxihu
 * @date 2019-11-27
 * @email androidhcx@163.com
 **/
public class FragmentSwitcher {

    private static FragmentManager fm;
    private static AppCompatActivity activity;


    public static void init(Context context) {
        activity = (AppCompatActivity) context;
        fm = activity.getSupportFragmentManager();
    }

    public static void hideMineFragment() {
        fm.beginTransaction()
                .hide(MineFragment.getInstance())
                .hide(LoginFragment.getInstance())
                .commit();
    }

    public static void showMineFragment() {
        fm.beginTransaction()
                .hide(GlobalConfig.isLogined ? LoginFragment.getInstance() :MineFragment.getInstance())
                .show(GlobalConfig.isLogined ? MineFragment.getInstance() : LoginFragment.getInstance())
                .commit();
    }

    public static void addFragment(BaseFragment fragment) {
        fm.beginTransaction()
                .add(R.id.rl_content, fragment)
                .commit();
    }

    public static void hideFragment(BaseFragment fragment) {
        fm.beginTransaction()
                .hide(fragment)
                .commit();
    }

    public static void showFragment(BaseFragment fragment) {
        fm.beginTransaction()
                .show(fragment)
                .commit();
    }

    public static void replaceFragment(BaseFragment fragment) {
        fm.beginTransaction()
                .replace(R.id.rl_content, fragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }


    public static void replaceUnAddToBackStackFragment(BaseFragment fragment) {
        fm.beginTransaction()
                .replace(R.id.rl_content, fragment)
                .commit();
    }

    public static void back() {
        fm.popBackStack();
    }
}
