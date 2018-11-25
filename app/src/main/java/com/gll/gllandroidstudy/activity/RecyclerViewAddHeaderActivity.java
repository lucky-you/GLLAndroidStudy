package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.PublicRecyclerViewAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.model.NoticeMessage;
import com.gll.gllandroidstudy.utils.BarUtils;
import com.gll.gllandroidstudy.view.RecyclerViewHeaderView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAddHeaderActivity extends BaseActivity {

    private SmartRefreshLayout smartRefreshLayout;
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
        smartRefreshLayout = get(R.id.smartRefreshLayout);

        LinearLayout llRootLayout = get(R.id.ll_root_layout);
        BarUtils.addMarginTopEqualStatusBarHeight(llRootLayout);
        BarUtils.setStatusBarColor(this, ContextCompat.getColor(BaseApplication.getInstance(), R.color.colorPrimary), 0);

        smartRefreshLayout.setRefreshHeader(new ClassicsHeader(this).setFinishDuration(500));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        publicRecyclerViewAdapter = new PublicRecyclerViewAdapter(getDateList());
        publicRecyclerView.setAdapter(publicRecyclerViewAdapter);
        publicRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        RecyclerViewHeaderView recyclerViewHeaderView = new RecyclerViewHeaderView(mContext);
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
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (smartRefreshLayout.getState().isOpening) {


                }

            }
        });
    }
}
