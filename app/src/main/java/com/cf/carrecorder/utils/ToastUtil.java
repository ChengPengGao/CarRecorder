package com.cf.carrecorder.utils;

import android.content.Context;
import android.widget.Toast;

import com.cf.carrecorder.app.CarRecorderApp;
import com.cf.carrecorder.app.CarRecorderContext;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class ToastUtil {

    public static void show(String msg){
        Toast.makeText(CarRecorderContext.context,msg,Toast.LENGTH_SHORT).show();
    }
}
