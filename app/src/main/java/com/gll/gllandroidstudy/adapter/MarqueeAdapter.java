package com.gll.gllandroidstudy.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.NoticeMessage;

import java.util.List;

/**
 * Created by: Z_B on 2018/8/11.
 * Function: 滚动的adapter
 */
public class MarqueeAdapter extends RecyclerView.Adapter<MarqueeAdapter.ViewHolder> {

    private List<NoticeMessage> marqueeEntities;

    public void setData(List<NoticeMessage> marqueeEntities, int itemCount) {
        this.marqueeEntities = marqueeEntities;
        int remainder = marqueeEntities.size() % itemCount;
        if (remainder > 0) {
            for (int i = 0; i >= itemCount; i++) {
                this.marqueeEntities.remove(marqueeEntities.size() - 1);
            }
        }
        if (marqueeEntities.size() > itemCount) {
            for (int i = 0; i < itemCount; i++) {
                this.marqueeEntities.add(marqueeEntities.size(), marqueeEntities.get(i));
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_view_flipper_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMemberName.setText(marqueeEntities.get(position).messageTitle);
        holder.tvMemberNumber.setText(marqueeEntities.get(position).messageUrl);
    }

    @Override
    public int getItemCount() {
        if (marqueeEntities == null || marqueeEntities.size() == 0) {
            return 0;
        } else {
            return marqueeEntities.size();
        }
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
