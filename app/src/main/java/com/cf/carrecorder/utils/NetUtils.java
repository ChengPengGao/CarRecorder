package com.cf.carrecorder.utils;

/**
 * @author chenxihu
 * @date 2020-01-10
 * @email androidhcx@163.com
 **/
public class NetUtils {
    public static boolean isNetUrl(String url) {
        boolean reault = false;
        if (url != null) {
            if (url.toLowerCase().startsWith("http") || url.toLowerCase().startsWith("rtsp") || url.toLowerCase().startsWith("mms")) {
                reault = true;
            }
        }
        return reault;
    }
}
