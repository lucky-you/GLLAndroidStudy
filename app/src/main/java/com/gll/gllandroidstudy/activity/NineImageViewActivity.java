package com.gll.gllandroidstudy.activity;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.NineGridViewImageAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.model.NineImageList;
import com.gll.gllandroidstudy.utils.BarUtils;
import com.gll.gllandroidstudy.utils.DateImageUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NineImageViewActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private NineGridViewImageAdapter nineGridViewImageAdapter;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_nine_image_view);
    }

    @Override
    protected void bindViews() {
        initTitle("九宫格图片显示");
        BarUtils.addMarginTopEqualStatusBarHeight(get(R.id.ll_root_layout));
        BarUtils.setStatusBarColor(this, ContextCompat.getColor(BaseApplication.getInstance(), R.color.colorPrimary), 0);
        recyclerView = get(R.id.recyclerView);
    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {


        nineGridViewImageAdapter = new NineGridViewImageAdapter(DateImageUtils.getNineImageList(), mContext);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(nineGridViewImageAdapter);
    }

    @Override
    protected void setListener() {

    }
}
