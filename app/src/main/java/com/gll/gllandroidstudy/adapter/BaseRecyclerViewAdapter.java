package com.gll.gllandroidstudy.adapter;

import android.support.annotation.LayoutRes;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.rv.BaseViewHolder;
import com.gll.gllandroidstudy.base.rv.adapter.SimpleAdapter;
import com.gll.gllandroidstudy.model.RecyclerViewList;

import java.util.List;

/**
 * Created by: Z_B on 2018/9/10.
 * Function:
 */
public class BaseRecyclerViewAdapter extends SimpleAdapter<RecyclerViewList> {
    public BaseRecyclerViewAdapter(List<RecyclerViewList> list, @LayoutRes int layoutId) {
        super(list, layoutId);
    }

    @Override
    protected void bind(BaseViewHolder holder, RecyclerViewList data) {
        holder.setText(R.id.tvMessageTitle, data.getTitle())
                .setText(R.id.tvMessageContent, data.getContent());
    }
}
