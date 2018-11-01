package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.model.TimeAndStatus;
import com.gll.gllandroidstudy.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择图片
 */
public class SelectImageViewActivity extends BaseActivity {


    SwipeRefreshLayout RefreshLayout;
    RecyclerView imageViewRecyclerView;
    RadioGroup ll_button_layout;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_image_view);
    }

    @Override
    protected void bindViews() {
        initTitle("TabLayout");
        RefreshLayout = get(R.id.RefreshLayout);
        ll_button_layout = get(R.id.ll_button_layout);
        imageViewRecyclerView = get(R.id.imageViewRecyclerView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {



    }


    @Override
    protected void setListener() {
    }


}
