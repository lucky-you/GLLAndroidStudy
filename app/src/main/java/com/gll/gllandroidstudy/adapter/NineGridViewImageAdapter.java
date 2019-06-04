package com.gll.gllandroidstudy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.NineImageList;
import com.gll.gllandroidstudy.nineimage.NineGridImageView;
import com.gll.gllandroidstudy.nineimage.NineGridImageViewAdapter;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/12/7
 * function  : 九宫格图片的展示
 */
public class NineGridViewImageAdapter extends RecyclerView.Adapter<NineGridViewImageAdapter.ImageViewHolder> {

    private List<NineImageList> imageList;
    private Context mContent;


    public NineGridViewImageAdapter(List<NineImageList> imageList, Context mContent) {
        this.imageList = imageList;
        this.mContent = mContent;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(View.inflate(mContent, R.layout.include_nine_image_item_view, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private NineGridImageView<String> nineImageContent;
        private TextView tvContent;

        public ImageViewHolder(View itemView) {
            super(itemView);
            nineImageContent = itemView.findViewById(R.id.nineGridView);
            tvContent = itemView.findViewById(R.id.tvContent);
            nineImageContent.setAdapter(mAdapter);
        }

        public void bind(int position) {
            nineImageContent.setImagesData(imageList.get(position).getImageList());
            tvContent.setText(imageList.get(position).getTitle());
        }
    }

    private NineGridImageViewAdapter<String> mAdapter = new NineGridImageViewAdapter<String>() {
        @Override
        protected void onDisplayImage(Context context, ImageView imageView, String s) {
            Glide.with(mContent).load(s).into(imageView);
        }


    };
}
