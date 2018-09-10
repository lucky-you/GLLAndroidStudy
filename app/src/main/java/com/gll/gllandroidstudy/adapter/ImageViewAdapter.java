package com.gll.gllandroidstudy.adapter;

import android.support.annotation.LayoutRes;
import android.widget.ImageView;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.rv.BaseViewHolder;
import com.gll.gllandroidstudy.base.rv.adapter.SimpleAdapter;
import com.gll.gllandroidstudy.model.ImageBean;

import java.util.List;

/**
 * Created by: Z_B on 2018/9/10.
 * Function:
 */
public class ImageViewAdapter extends SimpleAdapter<ImageBean> {
    public ImageViewAdapter(List<ImageBean> list,@LayoutRes int layoutId) {
        super(list, layoutId);
    }

    @Override
    protected void bind(BaseViewHolder holder, ImageBean data) {
        TextView textView = holder.getView(R.id.tv_image_name);
        textView.setText(data.getName());
        ImageView image = holder.getView(R.id.iv_image);
        image.setImageBitmap(data.getImage());
    }
}
