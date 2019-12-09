package com.cf.carrecorder.net.api;

import com.alibaba.fastjson.JSON;
import com.cf.carrecorder.bean.request.BindBean;
import com.cf.carrecorder.bean.request.LoginBean;
import com.cf.carrecorder.bean.request.ReceiveBean;
import com.cf.carrecorder.bean.request.RegistBean;
import com.cf.carrecorder.bean.request.SendCodeBean;
import com.cf.carrecorder.utils.TypeSafer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class CarRecorderApi {
    public static ExecutorService service = new ThreadPoolExecutor( 0, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue<>(), r -> {
        Thread thread = new Thread( r );
        thread.setName( "CarRecorderApiThread" );
        return thread;
    } );

    /**
     * 发送验证码
     *
     * @param phone
     * @return
     */
    public static Observable sendCode(String phone) {
        SendCodeBean sendCodeBean = new SendCodeBean();
        sendCodeBean.setPhone( phone );
        String jsonString = JSON.toJSONString( sendCodeBean );
        RequestBody requestParams = RequestBody.create( MediaType.parse( "application/json" ), jsonString );
        return AppNetwordManager.getApiService().sendCode( requestParams );
    }

    /**
     * 注册
     *
     * @param userName
     * @param password
     * @param phone
     * @return
     */
    public static Observable register(String userName, String password, String phone, String captcha) {

        RegistBean registBean = new RegistBean();
        registBean.setUserName( userName );
        registBean.setPassword( password );
        registBean.setPhone( phone );
        registBean.setCaptcha( captcha );
        String jsonString = JSON.toJSONString( registBean );
        RequestBody requestParams = RequestBody.create( MediaType.parse( "application/json" ), jsonString );
        return AppNetwordManager.getApiService().register( requestParams );
    }

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    public static Observable login(String phone, String password) {
        LoginBean loginBean = new LoginBean();
        loginBean.setPhone( phone );
        loginBean.setPassword( password );
        String jsonString = JSON.toJSONString( loginBean );
        RequestBody requestParams = RequestBody.create( MediaType.parse( "application/json" ), jsonString );
        return AppNetwordManager.getApiService().login( requestParams );

    }

    /**
     * 绑定设备
     *
     * @param userId
     * @param deviceNo
     * @return
     */
    public static Observable bind(String userId, String deviceNo, String deviceAlias, String devCode) {
        BindBean bindBean = new BindBean();
        bindBean.setUserId( TypeSafer.parseInt( userId ) );
        bindBean.setDeviceNo( deviceNo );
        bindBean.setDeviceAlias( deviceAlias );
        bindBean.setDevCode( devCode );
        String jsonString = JSON.toJSONString( bindBean );
        RequestBody requestParams = RequestBody.create( MediaType.parse( "application/json" ), jsonString );
        return AppNetwordManager.getApiService().bind( requestParams );
    }

    /**
     * 设备上传信息
     *
     * @param receiveBean
     * @return
     */
    public static Observable receive(ReceiveBean receiveBean) {
        String jsonString = JSON.toJSONString( receiveBean );
        RequestBody requestParams = RequestBody.create( MediaType.parse( "application/json" ), jsonString );
        return AppNetwordManager.getApiService().receive( requestParams );
    }
}
