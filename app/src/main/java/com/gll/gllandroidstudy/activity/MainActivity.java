package com.gll.gllandroidstudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.utils.BarUtils;

/**
 * 链接夜神模拟器 adb connect 127.0.0.1:62001
 */
public class MainActivity extends BaseActivity {

    private final String[] mItems = {
            "ViewFlipper实现垂直轮播广告效果",
            "RecyclerView添加头部布局使用",
            "Cache的使用",
            "NestedScrollView滑动的监听",
            "SpannableString",
            "BaseRecyclerViewAdapter",
            "图片选择",
            "城市的三级选择"

    };
    private final Class<?>[] mClasses = {
            ViewFlipperActivity.class,
            RecyclerViewAddHeaderActivity.class,
            CacheActivity.class,
            SignInStepViewActivity.class,
            SpannableStringActivity.class,
            BaseRecyclerViewAdapter.class,
            SelectImageViewActivity.class,
            SelectCityActivity.class
    };


    private ListView listView;

    private LinearLayout llRootLayout;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void bindViews() {
        initNoBackTitle("首页内容");
        listView = get(R.id.listView);
        llRootLayout = get(R.id.ll_root_layout);
        BarUtils.addMarginTopEqualStatusBarHeight(llRootLayout);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        listView.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_expandable_list_item_1, mItems));
    }

    @Override
    protected void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, mClasses[position]);
                startActivity(intent);
            }
        });
    }
}
