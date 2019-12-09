package com.cf.carrecorder.net.api;

import com.cf.carrecorder.config.GlobalConstants;
import com.cf.carrecorder.net.convert.FastJsonConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class AppNetwordManager {
    private static ApiService apiService;
    private static OkHttpClient.Builder client;

    public static ApiService getApiService() {

        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getClient())
                    .baseUrl(GlobalConstants.BASE_URL)
                    .addConverterFactory(FastJsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            apiService = retrofit.create(ApiService.class);

        }
        return apiService;
    }


    /**
     * 创建客户端
     *
     * @return
     */
    public static OkHttpClient getClient(Interceptor... interceptors) {

        if (client == null) {
            synchronized (AppNetwordManager.class) {
                if (client == null) {
                    client = new OkHttpClient.Builder()
                            .addInterceptor(new HeaderIntercept())
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS);
                    for (Interceptor interceptor : interceptors) {
                        if (interceptor != null) {
                            client.addInterceptor(interceptor);
                        }
                    }
                }
            }
        }


        return client.build();
    }
}
