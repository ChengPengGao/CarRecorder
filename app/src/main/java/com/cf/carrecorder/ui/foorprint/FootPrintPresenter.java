package com.cf.carrecorder.ui.foorprint;

import com.cf.carrecorder.base.fragment.BaseFragmentPresenter;
import com.cf.carrecorder.base.fragment.BaseFragmentView;
import com.cf.carrecorder.bean.GridBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chenxihu
 * @date 2019-11-18
 * @email androidhcx@163.com
 **/
public class FootPrintPresenter extends BaseFragmentPresenter<BaseFragmentView> {

    FootPrintView v;

    @Override
    protected void attachView(BaseFragmentView frgView) {
        this.v = (FootPrintView) frgView;
    }




    public void loadGridData() {

        List<GridBean> gridBeans = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            GridBean gridBean = new GridBean();
            gridBean.setTime(new SimpleDateFormat("HH:mm").format(new Date()));
            gridBean.setCode("浙A " + (i+10000));
            gridBeans.add(gridBean);
        }

        v.showGridData(gridBeans);
    }
}
