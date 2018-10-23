package com.gll.gllandroidstudy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.NoticeMessage;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/10/18
 * function  : 垂直滚动的RecyclerView的adapter
 */
public class NoticeRecyclerViewAdapter extends BaseQuickAdapter<NoticeMessage, BaseViewHolder> {


    public NoticeRecyclerViewAdapter(@Nullable List<NoticeMessage> data) {
        super(R.layout.include_view_flipper_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NoticeMessage item) {
        helper.setText(R.id.tv_member_name, item.messageTitle)
                .setText(R.id.tv_member_number, item.messageUrl);
    }

    @Nullable
    @Override
    public NoticeMessage getItem(int position) {
        int newPosition = position % getData().size();
        return getData().get(newPosition);
    }

    @Override
    public int getItemViewType(int position) {
        //刚开始进入包含该类的activity时,count为0。就会出现0%0的情况，这会抛出异常，所以我们要在下面做一下判断
        int count = getHeaderLayoutCount() + getData().size();
        if (count <= 0) {
            count = 1;
        }
        int newPosition = position % count;
        return super.getItemViewType(newPosition);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }


}
