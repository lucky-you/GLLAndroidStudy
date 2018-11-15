package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.model.TimeAndStatus;
import com.gll.gllandroidstudy.utils.BarUtils;
import com.gll.gllandroidstudy.utils.CommonUtil;
import com.gll.gllandroidstudy.utils.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择图片
 */
public class SelectImageViewActivity extends BaseActivity {

    private LinearLayout llRootLayout;

    private TextView tvTitle;
    private RelativeLayout rlTitleLayout;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_image_view);
    }

    @Override
    protected void bindViews() {
        initTitle("TabLayout");
        llRootLayout = get(R.id.ll_root_layout);
        tvTitle = get(R.id.titlebar_tv_left);
        rlTitleLayout = get(R.id.rl_titlebar);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        BarUtils.addMarginTopEqualStatusBarHeight(llRootLayout);

    }


    @Override
    protected void setListener() {
    }


}
