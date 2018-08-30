package com.gll.gllandroidstudy.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.view.SignInStepView;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Z_B
 * @date : 2018/8/14
 * @function : 签到流程的activity
 */
public class SignInStepViewActivity extends BaseActivity {
    private NestedScrollView nestScrollView;
    private LinearLayout llTopTitleLayout;
    private ImageView ivTopBannerImageView, ivBackReturnImageView, ivCollectionImageView;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_signin_stepview);

    }

    @Override
    protected void bindViews() {
        nestScrollView = get(R.id.nestScrollView);
        llTopTitleLayout = get(R.id.ll_top_title_layout);
        ivTopBannerImageView = get(R.id.iv_banner_imageView);
        ivBackReturnImageView = get(R.id.iv_back_return);
        ivCollectionImageView = get(R.id.iv_collection_grey);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void setListener() {
        ivBackReturnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nestScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });


    }
}
