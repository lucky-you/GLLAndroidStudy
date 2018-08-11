package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ViewFlipper;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.MarqueeAdapter;
import com.gll.gllandroidstudy.adapter.ViewFlipperAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.model.NoticeMessage;
import com.gll.gllandroidstudy.view.MarqueeView;

import java.util.ArrayList;
import java.util.List;

public class ViewFlipperActivity extends BaseActivity {



    private MarqueeView marqueeView;
    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_tab_layout);
    }


    @Override
    protected void bindViews() {
        initTitle("ViewFlipper");
        marqueeView = get(R.id.marqueeView);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        List<NoticeMessage> noticeMessageList = new ArrayList<>();
        noticeMessageList.add(new NoticeMessage("会员0", "87248770"));
        noticeMessageList.add(new NoticeMessage("会员1", "87248771"));
        noticeMessageList.add(new NoticeMessage("会员2", "87248772"));
        noticeMessageList.add(new NoticeMessage("会员3", "87248773"));
        noticeMessageList.add(new NoticeMessage("会员4", "87248774"));
        noticeMessageList.add(new NoticeMessage("会员5", "87248775"));
        noticeMessageList.add(new NoticeMessage("会员6", "87248776"));
        noticeMessageList.add(new NoticeMessage("会员7", "87248777"));
        noticeMessageList.add(new NoticeMessage("会员8", "87248778"));
        noticeMessageList.add(new NoticeMessage("会员9", "87248779"));
        MarqueeAdapter marqueeAdapter=new MarqueeAdapter();
        marqueeAdapter.setData(noticeMessageList,2);
        marqueeView.setAdapter(marqueeAdapter);
    }

    @Override
    protected void setListener() {

    }
}
