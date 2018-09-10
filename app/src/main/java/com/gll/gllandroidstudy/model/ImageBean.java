package com.gll.gllandroidstudy.model;

import android.graphics.Bitmap;
import android.support.annotation.StringRes;

import com.gll.gllandroidstudy.base.BaseApplication;

/**
 * Created by: Z_B on  2018/9/10.
 * Function: 图片的相关
 */
public class ImageBean {


    int resId;
    String name;
    Bitmap image;

    public ImageBean(@StringRes int resId, Bitmap image) {
        name = BaseApplication.getInstance().getString(resId);
        this.image = image;
    }

    public ImageBean(String name, Bitmap image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
