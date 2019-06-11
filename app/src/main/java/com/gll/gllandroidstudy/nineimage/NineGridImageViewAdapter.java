package com.gll.gllandroidstudy.nineimage;

import android.content.Context;
import android.widget.ImageView;

import com.gll.gllandroidstudy.utils.SizeUtils;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * item的adapter
 */
public abstract class NineGridImageViewAdapter<T> {
    protected abstract void onDisplayImage(Context context, ImageView imageView, T t);

    protected void onItemImageClick(Context context, ImageView imageView, int index, List<T> list) {
    }

    protected boolean onItemImageLongClick(Context context, ImageView imageView, int index, List<T> list) {
        return false;
    }

    protected ImageView generateImageView(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }
}