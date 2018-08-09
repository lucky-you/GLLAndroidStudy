package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ViewFlipper;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.ViewFlipperAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.model.NoticeMessage;

import java.util.ArrayList;
import java.util.List;

public class ViewFlipperActivity extends BaseActivity {


    private ViewFlipper marqueeViewFlipper;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_tab_layout);
    }


    @Override
    protected void bindViews() {
        initTitle("ViewFlipper");
        marqueeViewFlipper = get(R.id.marquee_viewFlipper);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        List<NoticeMessage> noticeMessageList = new ArrayList<>();
        noticeMessageList.add(new NoticeMessage("会员1", "87248773"));
        noticeMessageList.add(new NoticeMessage("会员2", "87248773"));
        noticeMessageList.add(new NoticeMessage("会员3", "87248773"));
        noticeMessageList.add(new NoticeMessage("会员4", "87248773"));
        noticeMessageList.add(new NoticeMessage("会员5", "87248773"));

        RecyclerView recyclerView = new RecyclerView(mContext);
        recyclerView.setAdapter(new ViewFlipperAdapter(noticeMessageList));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        marqueeViewFlipper.addView(recyclerView);

    }

    @Override
    protected void setListener() {

    }
}
