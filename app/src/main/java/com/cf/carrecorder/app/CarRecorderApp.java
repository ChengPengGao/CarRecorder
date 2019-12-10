package com.cf.carrecorder.app;

import android.app.Application;
import android.content.Context;

import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.config.GlobalConstants;
import com.cf.carrecorder.utils.SPUtil;

import me.jessyan.autosize.AutoSizeConfig;

/**
 * @author chenxihu
 * @date 2019-11-13
 * @email androidhcx@163.com
 **/
public class CarRecorderApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CarRecorderContext.context = this;
        AutoSizeConfig.getInstance().setBaseOnWidth(false);




        SPUtil.init(this);
        initConfig();

    }

    private void initConfig() {
        GlobalConfig.isLogined = SPUtil.getBoolean(GlobalConstants.IS_LOGIN,false);
        GlobalConfig.userId = SPUtil.getString(GlobalConstants.USER_ID);
        GlobalConfig.userPhone = SPUtil.getString(GlobalConstants.USER_PHONE);
        GlobalConfig.isBinded = SPUtil.getBoolean(GlobalConstants.IS_BINDED,false);
    }
}
