package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.LGNineGridViewAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.utils.DateImageUtils;

public class ViewPagerVideoActivity extends BaseActivity {

    public RecyclerView publicRecyclerView;
    private LGNineGridViewAdapter lgNineGridViewAdapter;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_view_pager_video);
    }

    @Override
    protected void bindViews() {
        initTitle("自定义ViewGroup显示九宫格列表展示");
        publicRecyclerView = get(R.id.publicRecyclerView);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        lgNineGridViewAdapter = new LGNineGridViewAdapter(DateImageUtils.getNineImageList(), mContext);
        publicRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        publicRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayout.VERTICAL));
        publicRecyclerView.setAdapter(lgNineGridViewAdapter);

    }


    @Override
    protected void setListener() {

    }
}
