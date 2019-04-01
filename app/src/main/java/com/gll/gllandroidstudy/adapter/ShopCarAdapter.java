package com.gll.gllandroidstudy.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.ShopMessageList;
import com.gll.gllandroidstudy.widget.DivideLineItemDecoration;

import java.util.List;

/**
 * Created by: Z_B on 2019/4/1.
 * Function: 购物车的adapter
 */
public class ShopCarAdapter extends BaseQuickAdapter<ShopMessageList, BaseViewHolder> {
    public ShopCarAdapter(@Nullable List<ShopMessageList> data) {
        super(R.layout.include_shaop_car_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final ShopMessageList item) {
        helper.setText(R.id.tvShopName, item.getShopName())
                .setImageResource(R.id.ivShopSelect, item.isShopSelect() ? R.drawable.ic_red_choice : R.drawable.ic_grey_choice)
                .getView(R.id.ivShopSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isShopSelect = !item.isShopSelect();
                item.setShopSelect(isShopSelect);
                notifyDataSetChanged();
            }
        });

        RecyclerView recyclerView = helper.getView(R.id.recyclerView);
        final ShopGoodListAdapter shopGoodListAdapter = new ShopGoodListAdapter(item.getGoodList());
        recyclerView.addItemDecoration(new DivideLineItemDecoration(mContext, mContext.getResources().getColor(R.color.color_f3f3f3), 1));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(shopGoodListAdapter);

        shopGoodListAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ivGoodSelect:
                        boolean isGoodSelect = !shopGoodListAdapter.getItem(position).isGoodSelect();
                        shopGoodListAdapter.getItem(position).setGoodSelect(isGoodSelect);
                        break;
                    case R.id.tvNumberReduce:

                        break;
                    case R.id.tvNumberAdd:

                        break;

                }
                shopGoodListAdapter.notifyDataSetChanged();
            }
        });

    }
}
