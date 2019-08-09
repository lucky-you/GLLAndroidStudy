package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.ProductTotalSizeAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

public class ProductTotalSizeActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private ProductTotalSizeAdapter productTotalSizeAdapter;


    private FlexboxLayout flexboxLayout;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_product_total_size);
    }

    @Override
    protected void bindViews() {
        initTitle("FlexboxLayout的使用");
        recyclerView = get(R.id.recyclerView);
        flexboxLayout = get(R.id.flexboxLayout);
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


        for (int i = 0; i < getList().size(); i++) {
            flexboxLayout.addView(getFlexboxLayoutItemView(i));
        }
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
        return textList;
    }


    //获取FlexboxLayout的子View
    private View getFlexboxLayoutItemView(int position) {
        View view = getLayoutInflater().inflate(R.layout.include_product_total_size_item_view, null, false);
        TextView itemTv = (TextView) view.findViewById(R.id.tvTitle);
        itemTv.setText(getList().get(position));
        return view;
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
