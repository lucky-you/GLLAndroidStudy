package com.gll.gllandroidstudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private final String[] mItems = {
            "ViewFlipper实现垂直轮播广告效果",
            "RecyclerView添加头部布局使用"

    };
    private final Class<?>[] mClasses = {
            ViewFlipperActivity.class,
            RecyclerViewAddHeaderActivity.class
    };

    private ListView listView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void bindViews() {
        initNoBackTitle("首页内容");
        listView = get(R.id.listView);
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
