package com.cf.carrecorder.ui.mine.reported.item;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cf.carrecorder.R;
import com.cf.carrecorder.adapter.reported.ReportedAdapter;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.bean.ReportedBean;
import com.cf.carrecorder.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class ItemFragment extends BaseFragment<ItemView,ItemPresenter> implements ItemView {

    @BindView(R.id.rv)
    RecyclerView rv;

    ReportedAdapter adapter;

    List<ReportedBean> datas;

    private int count;
    private String type;

    public ItemFragment(String type,int count) {
        this.count = count;
        this.type = type;
    }

    @Override
    protected void initView(View view) {
        datas = new ArrayList<>();
        adapter = new ReportedAdapter(datas);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new SpacesItemDecoration(1));
        presenter.loadReportedData(type,count);
    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_reported_item;
    }

    @Override
    protected ItemPresenter initPresenter() {
        return new ItemPresenter();
    }

    @Override
    public void showReportedData(List<ReportedBean> reportedBeans) {
        datas.clear();
        datas.addAll(reportedBeans);
        adapter.notifyDataSetChanged();
    }
}
