package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.ShopCarAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.model.GoodMessageList;
import com.gll.gllandroidstudy.model.ShopMessageList;
import com.gll.gllandroidstudy.utils.ConstantValue;
import com.gll.gllandroidstudy.widget.DivideLineItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车的逻辑
 */
public class ShopCarActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ImageView ivAllSelect;
    private TextView tvTotalPrice, tvSettleAccount;
    private List<ShopMessageList> shopMessageLists = new ArrayList<>();
    private ShopCarAdapter shopCarAdapter;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_shop_car);
    }

    @Override
    protected void bindViews() {
        recyclerView = get(R.id.recyclerView);
        ivAllSelect = get(R.id.ivAllSelect);
        tvTotalPrice = get(R.id.tvTotalPrice);
        tvSettleAccount = get(R.id.tvSettleAccount);
        ivAllSelect.setOnClickListener(this);
        tvSettleAccount.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initTitle("购物车结算逻辑");

        List<GoodMessageList> goodMessageListsOne = new ArrayList<>();
        goodMessageListsOne.add(new GoodMessageList(ConstantValue.imageThumbUrls[11], "白衬衣", 2, 85));
        goodMessageListsOne.add(new GoodMessageList(ConstantValue.imageThumbUrls[12], "男款夹克", 3, 140));
        goodMessageListsOne.add(new GoodMessageList(ConstantValue.imageThumbUrls[10], "羽绒服", 1, 588));

        List<GoodMessageList> goodMessageListsTwo = new ArrayList<>();
        goodMessageListsTwo.add(new GoodMessageList(ConstantValue.imageThumbUrls[0], "宝色连衣裙", 5, 118));
        goodMessageListsTwo.add(new GoodMessageList(ConstantValue.imageThumbUrls[3], "酒红色上衣", 2, 85));
        goodMessageListsTwo.add(new GoodMessageList(ConstantValue.imageThumbUrls[4], "黑色打底裤", 2, 70));

        List<GoodMessageList> goodMessageListsThree = new ArrayList<>();
        goodMessageListsThree.add(new GoodMessageList(ConstantValue.imageThumbUrls[7], "女款高跟鞋", 3, 150));
        goodMessageListsThree.add(new GoodMessageList(ConstantValue.imageThumbUrls[2], "精品凉鞋", 3, 88));
        goodMessageListsThree.add(new GoodMessageList(ConstantValue.imageThumbUrls[1], "女神贝雷帽", 4, 46));

        List<GoodMessageList> goodMessageListsFour = new ArrayList<>();
        goodMessageListsFour.add(new GoodMessageList(ConstantValue.imageThumbUrls[8], "乳白的格子衫", 2, 128));
        goodMessageListsFour.add(new GoodMessageList(ConstantValue.imageThumbUrls[5], "米黄色外套", 3, 238));
        goodMessageListsFour.add(new GoodMessageList(ConstantValue.imageThumbUrls[6], "立领羊毛衫", 1, 156));

        shopMessageLists.add(new ShopMessageList("海澜之家", goodMessageListsOne));
        shopMessageLists.add(new ShopMessageList("韩都衣舍", goodMessageListsTwo));
        shopMessageLists.add(new ShopMessageList("拉夏贝尔", goodMessageListsThree));
        shopMessageLists.add(new ShopMessageList("千千伊颂", goodMessageListsFour));

        shopCarAdapter = new ShopCarAdapter(shopMessageLists);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.addItemDecoration(new DivideLineItemDecoration(mContext, mContext.getResources().getColor(R.color.color_f3f3f3), 8));
        recyclerView.setAdapter(shopCarAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivAllSelect:

                break;
            case R.id.tvSettleAccount:
                showToast("去结算");
                break;

        }
    }

    @Override
    protected void setListener() {
    }
}