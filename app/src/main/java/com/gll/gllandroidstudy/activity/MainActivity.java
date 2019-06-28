package com.gll.gllandroidstudy.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.utils.BarUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 链接夜神模拟器 adb connect 127.0.0.1:62001
 */
public class MainActivity extends BaseActivity {


    private Map<String, Class<?>> mClassesMap = new HashMap<>();
    private final List<String> itemTitle = new ArrayList<>();
    private final List<Class<?>> classList = new ArrayList<>();
    private ListView listView;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void bindViews() {
        initNoBackTitle("首页内容");
        listView = get(R.id.listView);
        BarUtils.addMarginTopEqualStatusBarHeight(get(R.id.ll_root_layout));
        BarUtils.setStatusBarColor(this, ContextCompat.getColor(BaseApplication.getInstance(), R.color.colorPrimary), 0);

        mClassesMap.put("ViewFlipper实现垂直轮播广告效果", ViewFlipperActivity.class);
        mClassesMap.put("RecyclerView添加头部布局使用", RecyclerViewAddHeaderActivity.class);
        mClassesMap.put("GuideCaseView的使用", CacheActivity.class);
        mClassesMap.put("NestedScrollView滑动的监听", SignInStepViewActivity.class);
        mClassesMap.put("SpannableString", SpannableStringActivity.class);
        mClassesMap.put("BaseSimpleRecyclerView", RecyclerViewActivity.class);
        mClassesMap.put("图片选择", SelectImageViewActivity.class);
        mClassesMap.put("下载文件到本地", SelectCityActivity.class);
        mClassesMap.put("自定义ViewGroup显示九宫格图片", StarBarActivity.class);
        mClassesMap.put("自定义ViewGroup显示九宫格列表展示", ViewPagerVideoActivity.class);
        mClassesMap.put("自定义验证码输入框", EditTextCodeActivity.class);
        mClassesMap.put("流式布局的自定义", SelectYearAndMouthActivity.class);
        mClassesMap.put("九宫格图片显示", NineImageViewActivity.class);
        mClassesMap.put("自定义Banner", ScrollWheelSowActivity.class);
        mClassesMap.put("商品总数的滚动监听", ProductTotalSizeActivity.class);
        mClassesMap.put("GreenDao的使用", GreenDaoActivity.class);
        mClassesMap.put("TextView的展开与收起", ExpandableTextViewActivity.class);
        mClassesMap.put("RecyclerView嵌套实现购物车的逻辑", ShopCarActivity.class);
        mClassesMap.put("SectionedRV的使用", BottomTabActivity.class);
        mClassesMap.put("约束性布局的使用", ConstraintLayoutActivity.class);

        for (Map.Entry<String, Class<?>> entry : mClassesMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
            itemTitle.add(entry.getKey());
            classList.add(entry.getValue());
        }


    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        listView.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_expandable_list_item_1, itemTitle));
    }

    @Override
    protected void setListener() {
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(mContext, classList.get(position));
            startActivity(intent);
        });
    }
}
