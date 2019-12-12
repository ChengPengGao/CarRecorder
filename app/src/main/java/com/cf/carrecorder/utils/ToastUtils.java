package com.cf.carrecorder.utils;

import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;

import com.cf.carrecorder.app.CarRecorderContext;


/**
 * Toast 工具类
 *
 * @author chengpenggao
 */
public class ToastUtils {
    private static Toast lastToast;

    public static void showToast(int resourceId) {
        showToast( resourceId, Toast.LENGTH_SHORT );
    }

    public static void showToast(int resourceId, int duration) {
        showToast( CarRecorderContext.context.getResources().getString( resourceId ), duration );
    }

    public static void showToast(String message) {
        showToast( message, Toast.LENGTH_SHORT );
    }

    public static void showToast(String message, int duration) {
        if (TextUtils.isEmpty( message )) {
            return;
        }

        // 9.0 以上直接用调用即可防止重复的显示的问题，且如果复用 Toast 会出现无法再出弹出对话框问题
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Toast.makeText( CarRecorderContext.context, message, Toast.LENGTH_LONG ).show();
        } else {
            if (lastToast != null) {
                lastToast.setText( message );
            } else {
                lastToast = Toast.makeText( CarRecorderContext.context, message, Toast.LENGTH_LONG );
            }
            lastToast.show();
        }
    }
}
