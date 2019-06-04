package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.HomeTitlePageAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.fragment.SelectYearDateFragment;
import com.gll.gllandroidstudy.fragment.SelectYearFragment;
import com.gll.gllandroidstudy.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 仿珍爱网年月日选择
 */
public class SelectYearAndMouthActivity extends BaseActivity {




    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_year_and_mouth);
    }

    @Override
    protected void bindViews() {
        initTitle("仿珍爱网年月日选择");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
    }

    @Override
    protected void setListener() {
    }

    @Override
    public void onClick(View v) {
    }
}
