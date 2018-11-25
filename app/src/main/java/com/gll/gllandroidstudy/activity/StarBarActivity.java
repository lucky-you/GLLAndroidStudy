package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
        initTitle("沉浸式渐变状态栏").setTitleBgDrawable(BaseApplication.getInstance().getResources().getDrawable(R.drawable.shape_title_bg));
//        BarUtils.addMarginTopEqualStatusBarHeight(get(R.id.ll_root_layout));
//        BarUtils.setStatusBarColor(this, ContextCompat.getColor(BaseApplication.getInstance(), R.color.colorPrimary), 0);
        StatusUtils.transparentStatusBar(this);
        View titleView = get(R.id.title_view);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) titleView.getLayoutParams();
        layoutParams.height= BarUtils.getStatusBarHeight();

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }
}
