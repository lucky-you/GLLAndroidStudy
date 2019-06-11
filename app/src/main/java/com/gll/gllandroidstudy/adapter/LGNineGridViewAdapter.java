package com.gll.gllandroidstudy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.NineImageList;
import com.gll.gllandroidstudy.view.LGNineGridView;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2019/6/11
 * function  : 九宫格展示的图片
 */
public class LGNineGridViewAdapter extends RecyclerView.Adapter<LGNineGridViewAdapter.ViewHolder> {

    private List<NineImageList> imageList;
    private Context mContext;

    public LGNineGridViewAdapter(List<NineImageList> imageList, Context mContext) {
        this.imageList = imageList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(mContext, R.layout.include_lg_image_item_view, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitleMessage.setText(imageList.get(position).getTitle());
        holder.nineGridView.setUrls(imageList.get(position).getImageList());
    }

    @Override
    public int getItemCount() {
        return imageList == null ? 0 : imageList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitleMessage;
        LGNineGridView nineGridView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitleMessage = itemView.findViewById(R.id.tvTitleMessage);
            nineGridView = itemView.findViewById(R.id.nineGridView);
        }
    }
}
