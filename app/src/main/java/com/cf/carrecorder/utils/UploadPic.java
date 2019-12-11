package com.cf.carrecorder.utils;

import android.text.format.DateFormat;
import android.util.Log;


import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.cf.carrecorder.app.CarRecorderContext;

import java.io.File;
import java.util.Date;

/**
 * @author chengpenggao
 * @date 2019/10/21
 */
public class UploadPic {

    private String url;
    /**
     * 与个人的存储区域有关
     */
//    private static final String ENDPOINT = "http://oss-cn-beijing.aliyuncs.com ";
    private static final String ENDPOINT = "http://oss-cn-hangzhou.aliyuncs.com ";
    /**
     * 上传仓库名
     */
//    private static final String BUCKET_NAME = "gaoye";
    private static final String BUCKET_NAME = "carpicstore";

    //        private static final String ACCESS_KEY_ID = "LTAI4FxnLZn6D9DTgD6epHuz";
    private static final String ACCESS_KEY_ID = "LTAIjcE3Lx7N6L6s";
    //        private static final String ACCESS_KEY_SECRET = "8W830Ipc9Umo86pX1cKB7JWAczPkdI";
    private static final String ACCESS_KEY_SECRET = "qwxwHaAhuiW3D4fhnA37sufquiXPid";

    private static OSS getOSSClient() {
        OSSCredentialProvider credentialProvider =
                new OSSPlainTextAKSKCredentialProvider( ACCESS_KEY_ID,
                        ACCESS_KEY_SECRET );
        return new OSSClient( CarRecorderContext.context, ENDPOINT, credentialProvider );
    }

    /**
     * 上传方法
     *
     * @param objectKey 标识
     * @param path      需上传文件的路径
     * @return 外网访问的路径
     */
    private static String upload(String objectKey, String path) {
        // 构造上传请求
        PutObjectRequest request =
                new PutObjectRequest( BUCKET_NAME,
                        objectKey, path );
        try {
            //得到client
            OSS client = getOSSClient();
            //上传获取结果
            client.asyncPutObject( request, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                @Override
                public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
                    Log.e( "oss","put_success" );
                }

                @Override
                public void onFailure(PutObjectRequest putObjectRequest, ClientException e, ServiceException e1) {
                    Log.e( "oss","put_fail" );
                }
            } );
            //获取可访问的url
            String url = client.presignPublicObjectURL( BUCKET_NAME, objectKey );
            //
            Log.e( "oss",String.format( "PublicObjectURL:%s", url ) );
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 上传普通图片
     *
     * @param path 本地地址
     * @return 服务器地址
     */
    public static String uploadImage(String path) {
        String key = getObjectImageKey( path );
        return upload( key, path );
    }

    /**
     * 返回key
     *
     * @param path 本地路径
     * @return key
     */
    //格式: image/201805/sfdsgfsdvsdfdsfs.jpg
    private static String getObjectImageKey(String path) {
        String fileMd5 = HashUtil.getMD5String( new File( path ) );
        String dateString = getDateString();
        return String.format( "image/%s/%s.jpg", dateString, fileMd5 );
    }

    private static String getDateString() {
        return DateFormat.format( "yyyyMM", new Date() ).toString();
    }

}
