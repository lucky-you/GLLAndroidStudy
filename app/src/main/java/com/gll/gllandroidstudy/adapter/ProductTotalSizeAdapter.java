package com.gll.gllandroidstudy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gll.gllandroidstudy.R;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2019/1/18
 * function  : 商品滑动
 */
public class ProductTotalSizeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ProductTotalSizeAdapter(@Nullable List<String> data) {
        super(R.layout.include_product_total_size_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tvTitle, item);

    }
}
