package com.cf.carrecorder.ui.mine.reported;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.cf.carrecorder.R;
import com.cf.carrecorder.adapter.ReportedFragmentAdapter;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.ui.mine.reported.item.ItemFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的举报
 *
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class ReportedFragment extends BaseFragment<ReportedView, ReportedPresenter> implements ReportedView {

    private static ReportedFragment instance;

    @BindView(R.id.tl)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager vp;

    ReportedFragmentAdapter adapter;

    public static ReportedFragment getInstance() {
        if (instance == null) {
            instance = new ReportedFragment();
        }

        return instance;
    }

    @Override
    protected void initView(View view) {
        List<String> titles = new ArrayList<>();
        titles.add("全部");
        titles.add("待审核");
        titles.add("审核成功");
        titles.add("审核失败");

        List<ItemFragment> fragments = new ArrayList<>();
        fragments.add(new ItemFragment(ItemFragment.REPORT_ALL,3));
        fragments.add(new ItemFragment(ItemFragment.REPORT_WAIT,4));
        fragments.add(new ItemFragment(ItemFragment.REPORT_SUCCESS,2));
        fragments.add(new ItemFragment(ItemFragment.REPORT_FAILED,1));
        adapter = new ReportedFragmentAdapter(getActivity().getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);
    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_reported;
    }

    @Override
    protected ReportedPresenter initPresenter() {
        return new ReportedPresenter();
    }


    @OnClick(R.id.iv_back)
    public void onClick(View view) {
        back();
    }
}
