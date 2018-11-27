package com.gll.gllandroidstudy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 配合tabLayout+viewPager使用的
 */
public class HomeTitlePageAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    public String[] titles;

    public HomeTitlePageAdapter(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;

    }

    public HomeTitlePageAdapter(FragmentManager fm, List<Fragment> mFragments, String[] titles) {
        super(fm);
        this.mFragments = mFragments;
        this.titles = titles;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles == null ? "" : titles[position];
    }


}
