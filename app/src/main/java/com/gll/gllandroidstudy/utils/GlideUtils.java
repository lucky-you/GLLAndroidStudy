package com.gll.gllandroidstudy.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.gll.gllandroidstudy.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * author      : Z_B
 * date       : 2018/11/21
 * function  : Glide图片加载的工具类
 */
public class GlideUtils {


    /**
     * 加载圆角图片
     */
    public static void loadRoundedImage(Context context, String url, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_boxing_default_image)
                .error(R.drawable.ic_boxing_default_image)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 加载圆形图片
     */
    public static void loadCircleImage(Context context, String url, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_boxing_default_image)
                .error(R.drawable.ic_boxing_default_image)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 图片模糊处理
     */
    public static void glideLoadTransformImage(Context context, String url, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_boxing_default_image)
                .error(R.drawable.ic_boxing_default_image)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .transforms(new BlurTransformation(25, 3));
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 加载普通图片
     */
    public static void loadImage(Context context, String url, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_boxing_default_image)
                .error(R.drawable.ic_boxing_default_image)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(context).load(url)
                .apply(options)
                .into(imageView);
    }
}
