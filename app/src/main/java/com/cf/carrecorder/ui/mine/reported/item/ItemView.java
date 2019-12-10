package com.cf.carrecorder.ui.mine.reported.item;

import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.ReportedBean;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public interface ItemView extends BaseFragmentView {
    void showReportedData(List<ReportedBean> datas);
}
