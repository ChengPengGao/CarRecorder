package com.cf.carrecorder.net.api;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class HeaderIntercept implements Interceptor {
    //测试使用接口


    @Override
    public Response intercept(Chain chain) throws IOException {
            Request.Builder request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json");
            Request build = request.build();
            return chain.proceed(build);

    }
}