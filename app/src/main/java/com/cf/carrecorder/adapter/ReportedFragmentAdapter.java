package com.cf.carrecorder.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cf.carrecorder.ui.mine.reported.item.ItemFragment;

import java.util.List;

/**
 * @author chenxihu
 * @date 2019-12-09
 * @email androidhcx@163.com
 **/
public class ReportedFragmentAdapter extends FragmentPagerAdapter {

    private List<ItemFragment> mFragments;
    private List<String> mTitles;

    public ReportedFragmentAdapter(FragmentManager fm, List<ItemFragment> fragments, List<String> titles) {
        super(fm);
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
