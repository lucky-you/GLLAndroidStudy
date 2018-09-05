package com.gll.gllandroidstudy.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bilibili.boxing.BoxingMediaLoader;
import com.bilibili.boxing.model.entity.BaseMedia;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.activity.SelectImageViewActivity;
import com.gll.gllandroidstudy.callback.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/9/5
 * function  :
 */
public class MediaResultAdapter extends RecyclerView.Adapter<MediaResultAdapter.ViewHolder> {

    private OnRecyclerViewItemClickListener listener;
    private boolean isAdded;   //是否额外添加了最后一个图片
    private int maxImgCount = 9;
    private List<BaseMedia> mDataList;


    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.listener = listener;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public void setMaxImgCount(int maxImgCount) {
        this.maxImgCount = maxImgCount;
    }

    public MediaResultAdapter(int maxImgCount, List<BaseMedia> mDataList) {
        this.maxImgCount = maxImgCount;
        this.mDataList = mDataList;
        setList(mDataList);
    }

    public void setList(List<BaseMedia> data) {
        mDataList = new ArrayList<>(data);
        if (getItemCount() < maxImgCount) {
            mDataList.add(new BaseMedia() {
                @Override
                public TYPE getType() {
                    return TYPE.IMAGE;
                }
            });
            isAdded = true;
        } else {
            isAdded = false;
        }
        notifyDataSetChanged();
    }
    public List<BaseMedia> getImages() {
        //由于图片未选满时，最后一张显示添加图片，因此这个方法返回真正的已选图片
        if (isAdded) return new ArrayList<>(mDataList.subList(0, mDataList.size() - 1));
        else return mDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.include_select_image_item_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
//        if (mDataList.size() == maxImgCount) {
//            isAdded = false;
//            return mDataList.size();
//        }
//        isAdded = true;
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView ivImageView, ivDeleteImage;
        private int clickPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImageView = itemView.findViewById(R.id.iv_image);
            ivDeleteImage = itemView.findViewById(R.id.iv_delete_image);


        }

        public void bindView(final int position) {
            ivImageView.setOnClickListener(this);
            //根据条目位置设置图片
            BaseMedia item = mDataList.get(position);
            if (isAdded && position == getItemCount() - 1) {
                ivImageView.setImageResource(R.drawable.ic_camera_bg);
                clickPosition = -1;
                ivDeleteImage.setVisibility(View.GONE);
            } else {
                BoxingMediaLoader.getInstance().displayThumbnail(ivImageView, item.getPath(), 100, 100);
                clickPosition = position;
                ivDeleteImage.setVisibility(View.VISIBLE);
                ivDeleteImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDataList.remove(position);
                        notifyDataSetChanged();
                    }
                });
            }

        }

        @Override
        public void onClick(View view) {
            if (listener != null) listener.onItemClick(ivImageView, clickPosition);
        }
    }

}
