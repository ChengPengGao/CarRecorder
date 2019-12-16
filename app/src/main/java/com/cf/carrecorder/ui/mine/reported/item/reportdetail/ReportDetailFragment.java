package com.cf.carrecorder.ui.mine.reported.item.reportdetail;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cf.carrecorder.R;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.bean.ReportListData;
import com.cf.carrecorder.utils.ListUtil;
import com.cf.carrecorder.utils.TypeSafer;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 违章举报详情
 *
 * @author chenxihu
 * @date 2019-12-16
 * @email androidhcx@163.com
 **/
public class ReportDetailFragment extends BaseFragment<ReportDetailView, ReportDetailPresenter> implements ReportDetailView {


    @BindView(R.id.ll_status)
    LinearLayout llStatus;

    @BindView(R.id.tv_status)
    TextView tvStatus;

    @BindView(R.id.tv_statusDetail)
    TextView tvStatusDetail;

    @BindView(R.id.tv_breakType)
    TextView tvBreakType;

    @BindView(R.id.tv_reportTime)
    TextView tvReportTime;

    @BindView(R.id.tv_breakTime)
    TextView tvBreakTime;

    @BindView(R.id.tv_address)
    TextView tvAddress;

    @BindView(R.id.tv_carType)
    TextView tvCarType;

    @BindView(R.id.tv_carNo)
    TextView tvCarNo;

    @BindView(R.id.iv_0)
    ImageView iv0;

    @BindView(R.id.iv_1)
    ImageView iv1;

    @BindView(R.id.iv_2)
    ImageView iv2;


    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private ReportListData.RowsBean data;

    public ReportDetailFragment(ReportListData.RowsBean data) {
        this.data = data;
    }

    @Override
    protected void initView(View view) {

        String breakType = "";
        switch (data.getBreakType()) {
            case 1:
                breakType = "违章掉头";
                break;
            case 2:
                breakType = "占用应急车道";
                break;
            case 3:
                breakType = "压双黄线";
                break;
            default:
                break;
        }

        String reportType;
        switch (data.getAuditStatus()) {
            case 0:
                reportType = "待审核";
                TypeSafer.text(tvStatusDetail, "请耐心等待");
                llStatus.setBackgroundColor(getContext().getResources().getColor(R.color.yellow));
                break;
            case 1:
                reportType = "审核成功";
                TypeSafer.text(tvStatusDetail, "该车将被处罚");
                llStatus.setBackgroundColor(getContext().getResources().getColor(R.color.green));
                break;
            case 2:
                reportType = "审核失败";
                TypeSafer.text(tvStatusDetail, "车牌无法辨识");
                llStatus.setBackgroundColor(getContext().getResources().getColor(R.color.red));
                break;
            default:
                reportType = "全部";
                break;
        }
        TypeSafer.text(tvStatus, reportType);
        TypeSafer.text(tvAddress, "违章地点：" + data.getAddress());
        TypeSafer.text(tvBreakTime, "违章时间：" + simpleDateFormat.format(data.getBreakTime()));
        TypeSafer.text(tvReportTime, "举报时间：" + simpleDateFormat.format(data.getReportTime()));
        TypeSafer.text(tvBreakType, "违章类型：" + breakType);
        TypeSafer.text(tvCarNo, "车牌号码：" + data.getCarNo());
        if (!ListUtil.isEmpty(data.getPhotoList())) {
            if (data.getPhotoList().size() >= 1 && !TextUtils.isEmpty(data.getPhotoList().get(0))) {
                Glide.with(getActivity())
                        .load(data.getPhotoList().get(0))
                        .into(iv0);
            }

            if (data.getPhotoList().size() >= 2 && !TextUtils.isEmpty(data.getPhotoList().get(1))) {
                Glide.with(getActivity())
                        .load(data.getPhotoList().get(1))
                        .into(iv1);
            }
            if (data.getPhotoList().size() >= 3 && !TextUtils.isEmpty(data.getPhotoList().get(2))) {
                Glide.with(getActivity())
                        .load(data.getPhotoList().get(2))
                        .into(iv2);
            }
        }

    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_reportdetail;
    }

    @Override
    protected ReportDetailPresenter initPresenter() {
        return new ReportDetailPresenter();
    }

    @OnClick(R.id.iv_back)
    public void onClick(View v){
        back();
    }
}
