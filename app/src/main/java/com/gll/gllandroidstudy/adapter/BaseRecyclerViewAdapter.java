package com.gll.gllandroidstudy.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.rv.BaseViewHolder;
import com.gll.gllandroidstudy.base.rv.adapter.SimpleAdapter;
import com.gll.gllandroidstudy.model.RecyclerViewList;
import com.gll.gllandroidstudy.widget.GlideRoundTransform;


import java.util.List;

/**
 * Created by: Z_B on 2018/9/10.
 * Function:
 */
public class BaseRecyclerViewAdapter extends SimpleAdapter<RecyclerViewList> {

    public BaseRecyclerViewAdapter(List<RecyclerViewList> list, int layoutId) {
        super(list, layoutId);
    }

    @Override
    protected void bind(BaseViewHolder holder, RecyclerViewList data) {
        String imageUrl = "http://img.mukewang.com/547d5a45000156f406000338.jpg";
        RequestOptions myOptions = new RequestOptions()
                .centerCrop()
                .transform(new GlideRoundTransform(mContext, 6));
        Glide.with(mContext)
                .load(imageUrl)
                .apply(myOptions)
                .into((ImageView) holder.getView(R.id.ivMessageUrl));
        holder.setText(R.id.tvMessageTitle, data.getTitle())
                .setText(R.id.tvMessageContent, data.getContent());
    }
}
