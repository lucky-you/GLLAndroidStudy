package com.gll.gllandroidstudy.activity;

import android.os.Bundle;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.utils.DateImageUtils;
import com.gll.gllandroidstudy.view.LGNineGridView;

/**
 * 沉浸式渐变状态栏
 */
public class StarBarActivity extends BaseActivity {


    private LGNineGridView nineGridView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_star_bar);
    }

    @Override
    protected void bindViews() {
        initTitle("自定义ViewGroup显示九宫格图片").setRightText("列表显示")
                .setRightOnClickListener(v -> intent2Activity(ViewPagerVideoActivity.class));
        nineGridView = get(R.id.nineGridView);


    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        nineGridView.setUrls(DateImageUtils.imageData(5));


    }

    @Override
    protected void setListener() {

    }
}
