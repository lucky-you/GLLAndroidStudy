package com.gll.gllandroidstudy.activity;

import android.os.Bundle;

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

    private SignInStepView signInStepView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_signin_stepview);

    }

    @Override
    protected void bindViews() {
        signInStepView = get(R.id.sivView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        List<String> mDateList = Arrays.asList("今天", "明天", "后天");
        signInStepView.setSteps(mDateList);
        signInStepView.selectedStep(2);


    }

    @Override
    protected void setListener() {

    }
}
