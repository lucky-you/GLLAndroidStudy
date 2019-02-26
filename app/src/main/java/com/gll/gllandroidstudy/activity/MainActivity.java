package com.gll.gllandroidstudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
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
            "城市的三级选择",
            "沉浸式渐变状态栏",
            "自定义验证码输入框",
            "仿珍爱网年月日选择",
            "九宫格图片显示",
            "从右往左轮播滚动",
            "商品总数的滚动监听",
            "GreenDao的使用",
            "TextView的展开与收起"

    };
    private final Class<?>[] mClasses = {
            ViewFlipperActivity.class,
            RecyclerViewAddHeaderActivity.class,
            CacheActivity.class,
            SignInStepViewActivity.class,
            SpannableStringActivity.class,
            BaseRecyclerViewAdapter.class,
            SelectImageViewActivity.class,
            SelectCityActivity.class,
            StarBarActivity.class,
            EditTextCodeActivity.class,
            SelectYearAndMouthActivity.class,
            NineImageViewActivity.class,
            ScrollWheelSowActivity.class,
            ProductTotalSizeActivity.class,
            GreenDaoActivity.class,
            ExpandableTextViewActivity.class
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
        BarUtils.setStatusBarColor(this, ContextCompat.getColor(BaseApplication.getInstance(), R.color.colorPrimary), 0);
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
