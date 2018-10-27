package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.model.TimeAndStatus;
import com.gll.gllandroidstudy.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择图片
 */
public class SelectImageViewActivity extends BaseActivity {


    SwipeRefreshLayout RefreshLayout;
    RecyclerView imageViewRecyclerView;
    RadioGroup ll_button_layout;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_image_view);
    }

    @Override
    protected void bindViews() {
        initTitle("TabLayout");
        RefreshLayout = get(R.id.RefreshLayout);
        ll_button_layout = get(R.id.ll_button_layout);
        imageViewRecyclerView = get(R.id.imageViewRecyclerView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        List<TimeAndStatus> timeAndStatusList = new ArrayList<>();
        timeAndStatusList.add(new TimeAndStatus("11:00", "抢购中"));
        timeAndStatusList.add(new TimeAndStatus("12:00", "即将开始"));
        timeAndStatusList.add(new TimeAndStatus("13:00", "即将开始"));
        timeAndStatusList.add(new TimeAndStatus("14:00", "即将开始"));
        timeAndStatusList.add(new TimeAndStatus("15:00", "即将开始"));

        for (int i = 0; i < timeAndStatusList.size(); i++) {
            RadioButton radioButton = new RadioButton(this);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, CommonUtil.dip2px(mContext, 40));
            layoutParams.setMargins(10, 10, 10, 10);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setText(timeAndStatusList.get(i).getStatus());
            radioButton.setTextSize(12);
            radioButton.setButtonDrawable(android.R.color.transparent);//隐藏单选圆形按钮
            radioButton.setGravity(Gravity.CENTER);
//            radioButton.setPadding(10, 10, 10, 10);
            ll_button_layout.addView(radioButton);//将单选按钮添加到RadioGroup中

        }


    }


    @Override
    protected void setListener() {
        RefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                RefreshLayout.setRefreshing(false);
            }
        });
    }


}
