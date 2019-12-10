package com.cf.carrecorder.ui.mine.reported.item;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.ReportedBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class ItemPresenter extends BaseFragmentPresenter {
    ItemView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (ItemView) frgView;
    }

    public void loadReportedData(String type,int count) {

        List<ReportedBean> datas = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ReportedBean reportedBean = new ReportedBean();
            reportedBean.setType("违章类型：违停");
            reportedBean.setTime("举报时间：2019-07-03 16:24:03");
            reportedBean.setStatus(type);
            datas.add(reportedBean);
        }

        v.showReportedData(datas);
    }
}
