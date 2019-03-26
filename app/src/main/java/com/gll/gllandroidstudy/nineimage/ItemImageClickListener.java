package com.gll.gllandroidstudy.nineimage;

import android.content.Context;
import android.widget.ImageView;

import java.util.List;

/**
 * item的点击事件
 */

public interface ItemImageClickListener<T> {
    void onItemImageClick(Context context, ImageView imageView, int index, List<T> list);
}
