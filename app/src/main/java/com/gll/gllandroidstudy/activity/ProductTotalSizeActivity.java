package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.ProductTotalSizeAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.widget.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class ProductTotalSizeActivity extends BaseActivity {


    private RecyclerView publicRecyclerView;
    private ProductTotalSizeAdapter productTotalSizeAdapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<String> stringList = new ArrayList<>();

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_product_total_size);
    }

    @Override
    protected void bindViews() {
        initTitle("商品总数的滚动监听");
        publicRecyclerView = get(R.id.publicRecyclerView);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        for (int i = 0; i < 105; i++) {
            stringList.add("我是标题" + i);
        }
        productTotalSizeAdapter = new ProductTotalSizeAdapter(stringList);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        publicRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        publicRecyclerView.addItemDecoration(new DividerGridItemDecoration(mContext, mContext.getResources().getColor(R.color.red_color_df4c56), 8));
        publicRecyclerView.setAdapter(productTotalSizeAdapter);
    }

    @Override
    protected void setListener() {

    }
}
