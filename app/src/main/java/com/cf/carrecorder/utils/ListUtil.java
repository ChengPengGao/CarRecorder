package com.cf.carrecorder.utils;


import android.app.ActivityManager;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;
/**
 * @author chenxihu
 * @date 2019-12-10
 * @email androidhcx@163.com
 **/

public class ListUtil {

    public static boolean isEmpty(final List<? extends Object> list) {
        return null == list || list.size() == 0;
    }

    public static int listSize(final List<? extends Object> list) {
        return (null == list) ? 0 : list.size();
    }

    public static <E> E getIndex(final List<E> list, final int i) {
        if (null == list || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }


    /**
     * 判断某个服务是否正在运行的方法
     *
     * @param mContext
     * @param serviceName 是包名+服务的类名（例如：net.loonggg.testbackstage.TestService）
     * @return true代表正在运行，false代表服务没有正在运行
     */
    public static boolean isServiceWork(Context mContext, String serviceName) {
        boolean isWork = false;
        ActivityManager myAM = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> myList = myAM.getRunningServices(40);
        if (myList.size() <= 0) {
            return false;
        }
        for (int i = 0; i < myList.size(); i++) {
            String mName = myList.get(i).service.getClassName().toString();
            if (mName.equals(serviceName)) {
                isWork = true;
                break;
            }
        }
        return isWork;
    }


    /**
     * 分割List
     *
     * @param list     待分割的list
     * @param pageSize 每段list的大小
     * @return List<<       List       <       T>>
     * @author bianrx
     * @date 2012.1.13
     */
    public static <T> List<List<T>> splitList(List<T> list, int pageSize) {

        //list的大小
        int listSize = list.size();
        //页数
        int page = (listSize + (pageSize - 1)) / pageSize;
        //创建list数组 ,用来保存分割后的list
        List<List<T>> listArray = new ArrayList<List<T>>();
        //按照数组大小遍历
        for (int i = 0; i < page; i++) {
            //数组每一位放入一个分割后的list
            List<T> subList = new ArrayList<T>();
            //遍历待分割的list
            for (int j = 0; j < listSize; j++) {
                //当前记录的页码(第几页)
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                //当前记录的页码等于要放入的页码时
                if (pageIndex == (i + 1)) {
                    //放入list中的元素到分割后的list(subList)
                    subList.add(list.get(j));
                }
                //当放满一页时退出当前循环

                if ((j + 1) == ((j + 1) * pageSize)) {
                    break;
                }
            }
            //将分割后的list放入对应的数组的位中
            listArray.add(subList);
        }
        return listArray;
    }
}
