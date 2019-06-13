package com.gll.gllandroidstudy.activity;

import android.os.Bundle;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;

public class RecyclerViewAddHeaderActivity extends BaseActivity {


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_recycler_view_add_header);
    }

    @Override
    protected void bindViews() {
        initTitle("RecyclerView添加头部");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }


    @Override
    protected void setListener() {
    }
}
