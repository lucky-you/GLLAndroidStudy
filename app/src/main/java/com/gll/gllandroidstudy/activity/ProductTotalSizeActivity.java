package com.gll.gllandroidstudy.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.ProductTotalSizeAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.model.AllAreaList;
import com.gll.gllandroidstudy.model.AreaComparatorLetter;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductTotalSizeActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private ProductTotalSizeAdapter productTotalSizeAdapter;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_product_total_size);
    }

    @Override
    protected void bindViews() {
        initTitle("FlexboxLayout的使用");
        recyclerView = get(R.id.recyclerView);
    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {

        productTotalSizeAdapter = new ProductTotalSizeAdapter(getList());

        //设置布局管理器
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(mContext);
        //flexDirection 属性决定主轴的方向（即项目的排列方向）。类似 LinearLayout 的 vertical 和 horizontal。
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);//主轴为水平方向，起点在左端。
        //flexWrap 默认情况下 Flex 跟 LinearLayout 一样，都是不带换行排列的，但是flexWrap属性可以支持换行排列。
        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);//按正常方向换行
        //justifyContent 属性定义了项目在主轴上的对齐方式。
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);//交叉轴的起点对齐。

        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setAdapter(productTotalSizeAdapter);
        productTotalSizeAdapter.setOnItemClickListener(this::onItemClick);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Type listType = new TypeToken<ArrayList<AllAreaList>>() {
                }.getType();
                Gson gson = new Gson();
                String JsonData = getJson(mContext, "all_area.json");//获取assets目录下的json文件数据
                final List<AllAreaList> list = gson.fromJson(JsonData, listType);
                Collections.sort(list, new AreaComparatorLetter());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("xy", "listSize=" + list.size() + "\n" + "list=" + list.toString());
                    }
                });
            }
        }).start();
    }


    public String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private List<String> getList() {
        List<String> textList = new ArrayList<>();
        textList.add("你好");
        textList.add("非常好");
        textList.add("大家好才是真的好");
        textList.add("不错");
        textList.add("你说好就好");
        textList.add("哈哈哈哈哈哈哈哈嘎嘎嘎");
        textList.add("爱要不错吗");
        textList.add("撒接口的发酵");
        textList.add("撒发酵");
        textList.add("很少见阿可兑换");
        textList.add("呼啦呼啦花脸节啊安徽接电话");
        textList.add("安康交换机你们");
        textList.add("安康机你们");
        textList.add("几点回家啊韩剧撒旦教");
        textList.add("按格式金黄色的和");
        textList.add("大姐姐萨大是点击姐姐萨科技上科他技上");
        textList.add("回到家卡号是大括号上架到打麻将你的卡");
        return textList;
    }


    @Override
    protected void setListener() {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        String title = productTotalSizeAdapter.getItem(position);
        showToast("点击了：" + title);

    }
}
