package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;

/**
 * 城市选择的activity
 */
public class SelectCityActivity extends BaseActivity {

    private TextView tvSelectCity;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_city);
    }

    @Override
    protected void bindViews() {
        initTitle("城市的三级选择");
        tvSelectCity = get(R.id.tv_select_city);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {
        tvSelectCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCity();
            }
        });

    }

    private void selectCity() {


    }
}