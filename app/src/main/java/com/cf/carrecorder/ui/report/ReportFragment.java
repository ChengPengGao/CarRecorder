package com.cf.carrecorder.ui.report;

import android.view.View;
import android.widget.EditText;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.ui.regist.RegistFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 违章举报
 * @author chenxihu
 * @date 2019-11-29
 * @email androidhcx@163.com
 **/
public class ReportFragment extends BaseFragment<ReportView,ReportPresenter> implements ReportView {

    private static  ReportFragment instance;
    /**
     * 违章类型
     */
    @BindView(R.id.et_type)
    EditText etType;

    /**
     * 违章行为
     */
    @BindView(R.id.et_detailed)
    EditText etDetailed;

    /**
     * 违章时间
     */
    @BindView(R.id.et_time)
    EditText etTime;

    /**
     * 违章地点
     */
    @BindView(R.id.et_place)
    EditText etPlace;

    /**
     * 车辆类型
     */
    @BindView(R.id.et_plateType)
    EditText etPlateType;

    /**
     * 车牌号码
     */
    @BindView(R.id.et_plateCode)
    EditText etPlateCode;

    /**
     * 举报人姓名
     */
    @BindView(R.id.et_name)
    EditText etName;

    /**
     * 身份证号码
     */
    @BindView(R.id.et_id)
    EditText etId;


    public static ReportFragment getInstance() {
        if (instance == null) {
            instance = new ReportFragment();
        }

        return instance;
    }


    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_report;
    }

    @Override
    protected ReportPresenter initPresenter() {
        return new ReportPresenter();
    }

    @OnClick(R.id.iv_back)
    public void onClick(View view){
        back();
    }
}
