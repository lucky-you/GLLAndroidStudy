package com.gll.gllandroidstudy.activity;

import android.os.Bundle;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.view.BannerLayout;
import com.gll.gllandroidstudy.view.CustomCountDownTimerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 滚动轮播的activity
 */
public class ScrollWheelSowActivity extends BaseActivity {

    private CustomCountDownTimerView customCountDownTimeView;
    private BannerLayout bannerView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_scroll_wheel_sow);
    }

    @Override
    protected void bindViews() {
        initTitle("自定义Banner");
        customCountDownTimeView = get(R.id.customCountDownTimeView);
        bannerView = findViewById(R.id.bannerView);


    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        customCountDownTimeView.setCountdownTime(10);
        customCountDownTimeView.startCountDown();

        List<Object> bannerList = new ArrayList<>();
        bannerList.add("http://img.mukewang.com/55237dcc0001128c06000338.jpg");
        bannerList.add("http://img.mukewang.com/551e470500018dd806000338.jpg");
        bannerList.add("http://img.mukewang.com/5518c3d7000175af06000338.jpg");
        bannerList.add("http://img.mukewang.com/551916790001125706000338.jpg");
        //banner 设置方法完毕时最后调用 start 方法
        bannerView.start(bannerList);

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
