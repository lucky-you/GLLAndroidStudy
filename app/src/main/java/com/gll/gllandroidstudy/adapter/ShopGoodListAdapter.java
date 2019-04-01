package com.gll.gllandroidstudy.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.GoodMessageList;

import java.util.List;

/**
 * Created by: Z_B on 2019/4/1.
 * Function: 店铺商品的adapter
 */
public class ShopGoodListAdapter extends BaseQuickAdapter<GoodMessageList, BaseViewHolder> {
    public ShopGoodListAdapter(@Nullable List<GoodMessageList> data) {
        super(R.layout.include_shop_good_list_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodMessageList item) {
        Glide.with(mContext).load(item.getGoodUrl()).into((ImageView) helper.getView(R.id.ivGoodUrl));
        helper.setText(R.id.tvGoodName, item.getGoodName())
                .setText(R.id.tvGoodPrice, "单价：" + item.getGoodPrice() + "元")
                .setText(R.id.tvGoodNumber, String.valueOf(item.getGoodNumber()))
                .setImageResource(R.id.ivGoodSelect, item.isGoodSelect() ? R.drawable.ic_red_choice : R.drawable.ic_grey_choice)
                .addOnClickListener(R.id.ivGoodSelect)
                .addOnClickListener(R.id.tvNumberReduce)
                .addOnClickListener(R.id.tvNumberAdd);

    }
}
