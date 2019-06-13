package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.view.Gravity;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.utils.DateImageUtils;
import com.gll.gllandroidstudy.view.BannerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 滚动轮播的activity
 */
public class ScrollWheelSowActivity extends BaseActivity {

    private BannerLayout bannerView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_scroll_wheel_sow);
    }

    @Override
    protected void bindViews() {
        initTitle("自定义Banner");
        bannerView = findViewById(R.id.bannerView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        bannerView.start(DateImageUtils.imageData(5));

    }

    @Override
    protected void setListener() {


    }

    @Override
    protected void onStop() {
        super.onStop();
        bannerView.bannerShutdown();
    }
}
