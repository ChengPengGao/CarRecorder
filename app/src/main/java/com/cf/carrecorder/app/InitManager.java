package com.cf.carrecorder.app;

import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.utils.SPUtil;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class InitManager {
    private static InitManager instance;

    public static InitManager getInstance(){
        if(instance == null){
            instance = new InitManager();
        }
        return instance;
    }

    public void logout(){
        SPUtil.clear();
        GlobalConfig.isLogined = false;
        GlobalConfig.isBinded = false;
    }
}
