package com.gll.gllandroidstudy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gll.gllandroidstudy.R;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2019/2/26
 * function  : 可以展开的TextView
 */
public class ExpandableTextViewAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ExpandableTextViewAdapter(@Nullable List<String> data) {
        super(R.layout.include_expandable_text_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.expandableTextView, item);

    }

}
