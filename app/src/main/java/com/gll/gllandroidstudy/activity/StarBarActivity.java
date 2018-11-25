package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.RelativeLayout;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.utils.BarUtils;

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
        initTitle("沉浸式渐变状态栏");
//        BarUtils.addMarginTopEqualStatusBarHeight(get(R.id.ll_root_layout));
//        BarUtils.setStatusBarColor(this, ContextCompat.getColor(BaseApplication.getInstance(), R.color.colorPrimary), 0);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }
}
