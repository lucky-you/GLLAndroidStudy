package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.ExpandableTextViewAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;

import java.util.Arrays;
import java.util.List;

public class ExpandableTextViewActivity extends BaseActivity {

    private RecyclerView TextViewRecyclerView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_expandable_text_view);
    }

    @Override
    protected void bindViews() {
        initTitle("TextView的展开与收起");
        TextViewRecyclerView = get(R.id.TextViewRecyclerView);


    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        String[] mPoems = getResources().getStringArray(R.array.poems_2);
        List<String> stringList=Arrays.asList(mPoems);

        ExpandableTextViewAdapter expandableTextViewAdapter=new ExpandableTextViewAdapter(stringList);
        TextViewRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        TextViewRecyclerView.setAdapter(expandableTextViewAdapter);


    }

    @Override
    protected void setListener() {

    }
}
