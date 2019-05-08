package com.gll.gllandroidstudy.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.ProductTotalSizeAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.utils.BarUtils;
import com.gll.gllandroidstudy.widget.DividerGridItemDecoration;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductTotalSizeActivity extends BaseActivity {

    private NestedScrollView nestedScrollView;
    private RecyclerView publicRecyclerView;
    private ProductTotalSizeAdapter productTotalSizeAdapter;
    private List<String> stringList = new ArrayList<>();
    private TextView tvCurrentNumber, tvTotalNumber;
    private LinearLayout llSizeNumberLayout;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_product_total_size);
    }

    @Override
    protected void bindViews() {
        initTitle("商品总数的滚动监听");

        nestedScrollView = get(R.id.nestedScrollView);
        publicRecyclerView = get(R.id.publicRecyclerView);
        tvCurrentNumber = get(R.id.tvCurrentNumber);
        tvTotalNumber = get(R.id.tvTotalNumber);
        llSizeNumberLayout = get(R.id.llSizeNumberLayout);

    }

    private int height;

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        for (int i = 0; i < 71; i++) {
            stringList.add("我是标题" + i);
        }
        productTotalSizeAdapter = new ProductTotalSizeAdapter(stringList);
        publicRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        publicRecyclerView.addItemDecoration(new DividerGridItemDecoration(mContext, mContext.getResources().getColor(R.color.red_color_df4c56), 10));
        publicRecyclerView.setAdapter(productTotalSizeAdapter);
        publicRecyclerView.setHasFixedSize(true);
        publicRecyclerView.setNestedScrollingEnabled(false);

//        View headerView = View.inflate(mContext, R.layout.include_recyclerview_header_layout, null);
//        productTotalSizeAdapter.setHeaderView(headerView);

        llSizeNumberLayout.setVisibility(View.GONE);

        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();


        publicRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();//获取LayoutManager
                if (manager != null && manager instanceof GridLayoutManager) {

                    int ScollYDistance = getScollYDistance(((GridLayoutManager) manager)); //滑动距离

                    int titleBarHeight = BarUtils.getStatusBarHeight() + BarUtils.getActionBarHeight() + DensityUtil.dp2px(44); //状态栏+标题栏+底部导航栏的高度

                    int TheActualHeight = height - titleBarHeight; //实际屏幕的高度

                    int itemScollYDistance = ScollYDistance - titleBarHeight;

                    Log.e("xy", "ScollYDistance--->" + ScollYDistance + "--titleBarHeight-->" + titleBarHeight + "--itemScollYDistance-->" + itemScollYDistance);

                    int itemHeight = DensityUtil.dp2px(160);
                    Log.e("xy", "itemHeight=" + itemHeight);

                    int countNumber = (itemScollYDistance / itemHeight);
                    Log.e("xy", "countNumber=" + countNumber);

                    if (countNumber > 10) {
                        llSizeNumberLayout.setVisibility(View.VISIBLE);
                        tvCurrentNumber.setText(String.valueOf(countNumber));
                        tvTotalNumber.setText(String.valueOf(stringList.size()));
                    } else {
                        llSizeNumberLayout.setVisibility(View.GONE);
                    }
                    int currentNumber = countNumber * 2;
                    Log.e("xy", "currentNumber=" + currentNumber);

                }
            }
        });

    }

    /**
     * 获取滑动的距离
     */
    public int getScollYDistance(GridLayoutManager layoutManager) {
        int position = layoutManager.findFirstVisibleItemPosition();
        View firstVisiableChildView = layoutManager.findViewByPosition(position);
        int itemHeight = firstVisiableChildView.getHeight();
        return (position) * itemHeight - firstVisiableChildView.getTop();
    }

    @Override
    protected void setListener() {

    }
}
