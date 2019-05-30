package com.gll.gllandroidstudy.activity;

import android.os.Bundle;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.utils.BarUtils;
import com.gll.gllandroidstudy.utils.StatusUtils;

/**
 * 沉浸式渐变状态栏
 */
public class StarBarActivity extends BaseActivity {


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_star_bar);
    }

    @Override
    protected void bindViews() {
        initTitle("沉浸式渐变状态栏")
                .setTitleBgDrawable(BaseApplication.getInstance().getResources().getDrawable(R.drawable.shape_title_bg));
        StatusUtils.transparentStatusBar(this);
        BarUtils.addMarginTopEqualStatusBarHeight(get(R.id.title_view));

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }
}
