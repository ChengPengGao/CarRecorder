package com.cf.carrecorder.ui.foorprint;

import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.GridBean;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-11-18
 * @email androidhcx@163.com
 **/
public interface FootPrintView extends BaseFragmentView {

    /**
     * 显示未绑定布局
     */
    void showUnBindLayout();

    /**
     * 显示绑定布局
     */
    void showBindLayout();

    /**
     * 显示网格布局
     */
    void showGrid();

    /**
     * 显示地图布局
     */
    void showMap();

    /**
     * 显示网格布局
     * @param datas
     */
    void showGridData(List<GridBean> datas);

    /**
     * 显示底部布局
     */
    void showBottomBar();

    /**
     * 显示添加布局
     */
    void showAddBar();
}
