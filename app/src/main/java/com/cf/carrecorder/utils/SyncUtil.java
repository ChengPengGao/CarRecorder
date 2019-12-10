package com.cf.carrecorder.utils;

import android.text.TextUtils;

import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.config.GlobalConstants;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class SyncUtil {
    public static void setUserId(String userId){
        if(TextUtils.isEmpty(userId)){
            GlobalConfig.isLogined = false;
            SPUtil.putBoolean(GlobalConstants.IS_LOGIN,false);
        }else{
            GlobalConfig.isLogined = true;
            SPUtil.putBoolean(GlobalConstants.IS_LOGIN,true);
        }
        GlobalConfig.userId = userId;
        SPUtil.putString(GlobalConstants.USER_ID,userId);
    }


    public static void setUserPhone(String userPhone){
        GlobalConfig.userPhone = userPhone;
        SPUtil.putString(GlobalConstants.USER_PHONE,userPhone);
    }

    public static void setIsBinded(boolean isBinded){
        SPUtil.putBoolean(GlobalConstants.IS_BINDED,isBinded);
    }
}
