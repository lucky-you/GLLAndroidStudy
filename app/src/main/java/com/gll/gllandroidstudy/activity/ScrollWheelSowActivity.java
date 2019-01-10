package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.view.CustomCountDownTimerView;
import com.gll.gllandroidstudy.view.RunTextView;

/**
 * 滚动轮播的activity
 */
public class ScrollWheelSowActivity extends BaseActivity {

    private TextView tvTitleRadio;
    private RunTextView tvRunTextView;
    private CustomCountDownTimerView customCountDownTimeView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_scroll_wheel_sow);
    }

    @Override
    protected void bindViews() {
        tvTitleRadio = get(R.id.tvTitleRadio);
        tvRunTextView = get(R.id.tvRunTextView);
        customCountDownTimeView = get(R.id.customCountDownTimeView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        String radioMessage = "我就这点出息:我只是个出来打野的，就是一个打野的。";
        tvRunTextView.setText(radioMessage);
        tvRunTextView.startAnim();

        customCountDownTimeView.setCountdownTime(10);
        customCountDownTimeView.startCountDown();
    }

    @Override
    protected void setListener() {
        customCountDownTimeView.setOnCountDownTimeFinishListener(new CustomCountDownTimerView.OnCountDownTimeFinishListener() {
            @Override
            public void countDownFinished() {
                showToast("倒计时完成");
            }
        });
    }
}
