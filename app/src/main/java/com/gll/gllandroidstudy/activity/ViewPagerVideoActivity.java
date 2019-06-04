package com.gll.gllandroidstudy.activity;

import android.os.Bundle;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;

public class ViewPagerVideoActivity extends BaseActivity {
    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_view_pager_video);
    }

    @Override
    protected void bindViews() {
        initTitle("仿抖音垂直切换视频");

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }
}
