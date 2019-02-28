package com.gll.gllandroidstudy.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.gll.gllandroidstudy.R;

/**
 * author      : Z_B
 * date       : 2019/2/28
 * function  :
 */
public class ViewPagerVideoAdapter extends RecyclerView.Adapter<ViewPagerVideoAdapter.ViewHolder> {

    private Context mContext;
    private int[] videos;

    public ViewPagerVideoAdapter(Context mContext, int[] videos) {
        this.mContext = mContext;
        this.videos = videos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.include_view_pager_video_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.videoView.setVideoURI(Uri.parse("android.resource://" + mContext.getPackageName() + "/" + videos[position]));
    }

    @Override
    public int getItemCount() {
        return videos.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        ImageView img_thumb;

        public ViewHolder(View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.video_view);
            img_thumb = itemView.findViewById(R.id.img_thumb);
        }
    }


}
