package com.cf.carrecorder.ui.mine.feedback;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 意见反馈
 *
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class FeedbackFragment extends BaseFragment<FeedbackView, FeedbackPresenter> implements FeedbackView {
    private static FeedbackFragment instance;

    public static BaseFragment getInstance() {
        if (instance == null) {
            instance = new FeedbackFragment();
        }
        return instance;
    }

    @BindView(R.id.et_feedback)
    EditText etFeedback;

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initRootView() {
        return R.layout.layout_feedback;
    }

    @Override
    protected FeedbackPresenter initPresenter() {
        return new FeedbackPresenter();
    }

    @OnClick(R.id.btn_send)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                if(TextUtils.isEmpty(etFeedback.getText().toString())){
                    ToastUtil.show("意见反馈不能为空");
                    return;
                }
                ToastUtil.show("反馈成功");
                hideSoftInput();
                break;
            default:
                break;
        }
    }
}
