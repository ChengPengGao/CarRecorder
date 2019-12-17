package com.cf.carrecorder.net.api;

import com.cf.carrecorder.bean.HttpResult;
import com.cf.carrecorder.bean.LoginData;
import com.cf.carrecorder.bean.RecordListData;
import com.cf.carrecorder.bean.ReportListData;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public interface ApiService {

    /**
     * 发送验证码
     * @param body
     * @return
     */
    @POST("app/sendCode")
    Observable<HttpResult> sendCode(@Body RequestBody body);
    /**
     * app注册接口
     * @return
     */
    @POST("app/register")
    Observable<HttpResult> register(@Body RequestBody body);

    /**
     * app登录接口
     * @param body
     * @return
     */
    @POST("app/login")
    Observable<HttpResult<LoginData>> login(@Body RequestBody body);

    /**
     * app用户绑定设备
     * @param body
     * @return
     */
    @POST("device/bind")
    Observable<HttpResult> bind(@Body RequestBody body);

    /**
     * 设备上传信息
     * @param body
     * @return
     */
    @POST("device/receive")
    Observable<HttpResult> receive(@Body RequestBody body);

    /**
     * 获取记录
     * @param body
     * @return
     */
    @POST("device/recordList")
    Observable<HttpResult<RecordListData>> recordList(@Body RequestBody body, @QueryMap HashMap<String, Object> param);

    /**
     * 上传违章记录
     * @param body
     * @return
     */
    @POST("app/report")
    Observable<HttpResult> report(@Body RequestBody body);

    /**
     * 获取违章记录
     * @param body
     * @param param
     * @return
     */
    @POST("app/reportList")
    Observable<String> reportList(@Body RequestBody body, @QueryMap HashMap<String, Object> param);

    /**
     * 收藏
     * @param body
     * @return
     */
    @POST("app/addConllection")
    Observable<HttpResult> addConllection(@Body RequestBody body);

    /**
     * 删除
     * @param body
     * @return
     */
    @POST("app/deleteConllection")
    Observable<HttpResult> deleteConllection(@Body RequestBody body);

}
