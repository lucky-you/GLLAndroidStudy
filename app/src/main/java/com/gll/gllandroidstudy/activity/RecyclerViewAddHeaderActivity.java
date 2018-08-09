package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.PublicRecyclerViewAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.model.NoticeMessage;
import com.gll.gllandroidstudy.view.RecyclerViewHeaderView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAddHeaderActivity extends BaseActivity {

    private RecyclerView publicRecyclerView;
    private PublicRecyclerViewAdapter publicRecyclerViewAdapter;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_recycler_view_add_header);
    }

    @Override
    protected void bindViews() {
        initTitle("RecyclerView添加头部");
        publicRecyclerView = get(R.id.publicRecyclerView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        publicRecyclerViewAdapter=new PublicRecyclerViewAdapter(getDateList());
        publicRecyclerView.setAdapter(publicRecyclerViewAdapter);
        publicRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        RecyclerViewHeaderView recyclerViewHeaderView=new RecyclerViewHeaderView(mContext);
        publicRecyclerViewAdapter.addHeaderView(recyclerViewHeaderView);

    }

    private List<NoticeMessage> getDateList() {
        List<NoticeMessage> mDates = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDates.add(new NoticeMessage("我是测试标题" + i, "我是测试内容" + i));
        }
        return mDates;

    }


    @Override
    protected void setListener() {

    }
}
