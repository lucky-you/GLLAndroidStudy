package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.utils.BarUtils;

/**
 * Created by: Z_B on 2018/8/12.
 * Function:
 */
public class CacheActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        BarUtils.setStatusBarAlpha(CacheActivity.this, 0, true);
    }

}
