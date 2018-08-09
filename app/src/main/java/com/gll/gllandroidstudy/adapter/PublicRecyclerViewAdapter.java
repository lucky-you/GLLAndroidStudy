package com.gll.gllandroidstudy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.NoticeMessage;

import java.util.IdentityHashMap;
import java.util.List;

/**
 * Created by: Z_B on 2018/8/8.
 * Function:
 */
public class PublicRecyclerViewAdapter extends BaseQuickAdapter<NoticeMessage, BaseViewHolder> {
    public PublicRecyclerViewAdapter(@Nullable List<NoticeMessage> data) {
        super(R.layout.include_public_recuclerview_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NoticeMessage item) {
        helper.setText(R.id.tv_title_one, item.messageTitle)
                .setText(R.id.tv_title_two, item.messageUrl);
    }
}
