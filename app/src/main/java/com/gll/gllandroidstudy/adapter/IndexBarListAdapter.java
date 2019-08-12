package com.gll.gllandroidstudy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.NineImageList;
import com.gll.gllandroidstudy.model.RecyclerViewList;
import com.gll.gllandroidstudy.utils.GlideUtils;

import java.util.List;

public class IndexBarListAdapter extends BaseQuickAdapter<RecyclerViewList, BaseViewHolder> {


    public IndexBarListAdapter(@Nullable List<RecyclerViewList> data) {
        super(R.layout.include_index_bar_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecyclerViewList item) {
        helper.setText(R.id.tvTitle, item.getContent());
        GlideUtils.loadImage(mContext, item.imageUrl, helper.getView(R.id.ivImage));

    }
}
