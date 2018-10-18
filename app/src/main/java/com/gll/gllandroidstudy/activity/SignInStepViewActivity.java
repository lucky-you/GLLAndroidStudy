package com.gll.gllandroidstudy.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.view.JudgeNestedScrollView;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/**
 * @author : Z_B
 * @date : 2018/8/14
 * @function : 签到流程的activity
 */
public class SignInStepViewActivity extends BaseActivity {
    private JudgeNestedScrollView nestScrollView;
    private LinearLayout llTopTitleLayout;
    private ImageView ivTopBannerImageView, ivBackReturnImageView, ivCollectionImageView;
    private TextView tvDetails;


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
        tvDetails = get(R.id.tv_details);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {


    }

    private int mScrollY = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void setListener() {
        ivBackReturnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nestScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            int lastScrollY = 0;
            int height = DensityUtil.dp2px(170);
            int color = ContextCompat.getColor(getApplicationContext(), R.color.white) & 0x00ffffff;

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (lastScrollY < height) {
                    scrollY = Math.min(height, scrollY);
                    mScrollY = scrollY > height ? height : scrollY;
                    llTopTitleLayout.setBackgroundColor(((255 * mScrollY / height) << 24) | color);
                }
                if (scrollY == 0) {
                    ivBackReturnImageView.setImageResource(R.drawable.ic_white_back_return);
                    ivCollectionImageView.setImageResource(R.drawable.ic_collection_white);
                    tvDetails.setVisibility(View.GONE);
                } else {
                    ivBackReturnImageView.setImageResource(R.drawable.ic_back_return);
                    ivCollectionImageView.setImageResource(R.drawable.ic_collection_grey);
                    tvDetails.setVisibility(View.VISIBLE);
                }
                lastScrollY = scrollY;
            }
        });

    }
}
