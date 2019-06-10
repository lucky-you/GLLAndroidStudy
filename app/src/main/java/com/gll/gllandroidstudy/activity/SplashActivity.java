package com.gll.gllandroidstudy.activity;

import com.gll.gllandroidstudy.R;

/**
 * author      : Z_B
 * date       : 2019/6/6
 * function  : 引导页
 */
public class SplashActivity extends BaseSplashActivity {
    @Override
    protected void onCreateActivity() {
        initSplashView(R.drawable.wall12);
        startSplash(false);
    }

    @Override
    protected void onSplashFinished() {
        MainActivity.start(this);
        finish();
    }
}
