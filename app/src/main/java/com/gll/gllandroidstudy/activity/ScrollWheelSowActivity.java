package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.view.BannerLayout;
import com.gll.gllandroidstudy.view.CustomCountDownTimerView;
import com.gll.gllandroidstudy.view.RunTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 滚动轮播的activity
 */
public class ScrollWheelSowActivity extends BaseActivity {

    private TextView tvTitleRadio;
    private RunTextView tvRunTextView;
    private CustomCountDownTimerView customCountDownTimeView;
    private BannerLayout bannerView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_scroll_wheel_sow);
    }

    @Override
    protected void bindViews() {
        initTitle("水平滚动TextView");
        tvTitleRadio = get(R.id.tvTitleRadio);
        tvRunTextView = get(R.id.tvRunTextView);
        customCountDownTimeView = get(R.id.customCountDownTimeView);
        bannerView =  findViewById(R.id.bannerView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        String radioMessage = "我就这点出息:我只是个出来打野的，就是一个打野的。";
        tvRunTextView.setText(radioMessage);
        tvRunTextView.startAnim();
        customCountDownTimeView.setCountdownTime(10);
        customCountDownTimeView.startCountDown();


        List<Object> bannerList = new ArrayList<>();
        bannerList.add("http://img.mukewang.com/55237dcc0001128c06000338.jpg");
        bannerList.add("http://img.mukewang.com/551e470500018dd806000338.jpg");
        bannerList.add("http://img.mukewang.com/5518c3d7000175af06000338.jpg");
        bannerList.add("http://img.mukewang.com/551916790001125706000338.jpg");
        //banner 设置方法完毕时最后调用 start 方法
        bannerView.start(bannerList);

    }

    @Override
    protected void setListener() {
        customCountDownTimeView.setOnCountDownTimeFinishListener(new CustomCountDownTimerView.OnCountDownTimeFinishListener() {
            @Override
            public void countDownFinished() {
                showToast("倒计时完成");
            }
        });

        bannerView.setOnBannerClickListener(new BannerLayout.OnBannerClickListener() {
            @Override
            public void onBannerClick(int position) {
                showToast("点击了" + position);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        bannerView.bannerShutdown();
    }
}
