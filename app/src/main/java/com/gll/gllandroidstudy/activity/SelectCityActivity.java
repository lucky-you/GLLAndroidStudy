package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.utils.BarUtils;


/**
 * 城市选择的activity
 */
public class SelectCityActivity extends BaseActivity {


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_city);
    }

    @Override
    protected void bindViews() {
        initTitle("城市的三级选择");

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }


}
