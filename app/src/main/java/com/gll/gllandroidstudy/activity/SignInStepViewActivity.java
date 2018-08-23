package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

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

    private RecyclerView publicRecyclerView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_signin_stepview);

    }

    @Override
    protected void bindViews() {
        publicRecyclerView = get(R.id.publicRecyclerView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {


    }

    @Override
    protected void setListener() {

    }
}
