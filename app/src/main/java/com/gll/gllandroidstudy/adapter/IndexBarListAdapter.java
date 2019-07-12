package com.gll.gllandroidstudy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gll.gllandroidstudy.Index.CityItemMessage;
import com.gll.gllandroidstudy.R;

import java.util.List;

/**
 * Created by : Z_B on 2019/7/12.
 * describe：
 */
public class IndexBarListAdapter extends RecyclerView.Adapter {
    public final static int VIEW_INDEX = 0;
    public final static int VIEW_CONTENT = 1;

    private Context mContext;
    private List<CityItemMessage> mList;

    public IndexBarListAdapter(Context context, List<CityItemMessage> List) {
        this.mContext = context;
        this.mList = List;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_INDEX) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_index, parent, false);
            IndexViewHolder holder = new IndexViewHolder(view);
            holder.tvIndex = view.findViewById(R.id.tv_index);
            return holder;
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_content, parent, false);
            ContentViewHolder holder = new ContentViewHolder(view);
            holder.tvName = view.findViewById(R.id.tv_name);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_INDEX) {
            ((IndexViewHolder) holder).tvIndex.setText(mList.get(position).getFirstWord());
        } else {
            ((ContentViewHolder) holder).tvName.setText(mList.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).isIndex()) {
            return VIEW_INDEX;
        } else {
            return VIEW_CONTENT;
        }
    }

    private static class IndexViewHolder extends RecyclerView.ViewHolder {
        TextView tvIndex;

        IndexViewHolder(View itemView) {
            super(itemView);
        }
    }

    private static class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        ContentViewHolder(View itemView) {
            super(itemView);
        }
    }
}
