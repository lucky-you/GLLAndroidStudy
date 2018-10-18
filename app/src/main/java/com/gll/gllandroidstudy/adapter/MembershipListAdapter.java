package com.gll.gllandroidstudy.adapter;

import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.rv.BaseViewHolder;
import com.gll.gllandroidstudy.base.rv.adapter.SimpleAdapter;
import com.gll.gllandroidstudy.model.NoticeMessage;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/10/18
 * function  :
 */
public class MembershipListAdapter extends SimpleAdapter<NoticeMessage> {


    public MembershipListAdapter(List<NoticeMessage> list, int layoutId) {
        super(list, layoutId);
    }

    @Override
    protected void bind(BaseViewHolder holder, NoticeMessage data) {
        TextView tvMemberName = holder.getView(R.id.tv_member_name);
        TextView tvMemberNumber = holder.getView(R.id.tv_member_number);
        tvMemberName.setText(data.messageTitle);
        tvMemberNumber.setText(data.messageUrl);

    }
}
