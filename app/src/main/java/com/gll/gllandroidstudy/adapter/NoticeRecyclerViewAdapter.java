package com.gll.gllandroidstudy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.NoticeMessage;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/10/18
 * function  :
 */
public class NoticeRecyclerViewAdapter extends RecyclerView.Adapter<NoticeRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<NoticeMessage> noticeMessageList;

    public NoticeRecyclerViewAdapter(Context mContext, List<NoticeMessage> noticeMessageList) {
        this.mContext = mContext;
        this.noticeMessageList = noticeMessageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.include_view_flipper_view, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (noticeMessageList.size() != 0) {
            NoticeMessage productionDetail = noticeMessageList.get(position % noticeMessageList.size());//ArithmeticException 分母可能为零
            holder.tvMemberName.setText(productionDetail.messageTitle);
            holder.tvMemberNumber.setText(productionDetail.messageUrl);
        }
    }


    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMemberName, tvMemberNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMemberName = itemView.findViewById(R.id.tv_member_name);
            tvMemberNumber = itemView.findViewById(R.id.tv_member_number);
        }

    }

}
