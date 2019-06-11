package com.gll.gllandroidstudy.view;

import android.content.Context;
import android.widget.ImageView;

import com.gll.gllandroidstudy.utils.GlideUtils;
import com.gll.gllandroidstudy.utils.SizeUtils;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * author      : Z_B
 * date       : 2019/6/11
 * function  :
 */
public class DefaultImageCreator implements LGNineGridView.ImageCreator {
    private static DefaultImageCreator defaultImageCreator;

    private DefaultImageCreator() {
    }

    public static DefaultImageCreator getInstance() {
        if (defaultImageCreator == null) {
            synchronized (LGNineGridView.class) {
                if (defaultImageCreator == null)
                    defaultImageCreator = new DefaultImageCreator();
            }
        }
        return defaultImageCreator;
    }

    @Override
    public ImageView createImageView(Context context) {
//        ImageView imageView = new ImageView(context);
        RoundedImageView imageView = new RoundedImageView(context);
        imageView.setCornerRadius(SizeUtils.dp2px(4));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    @Override
    public void loadImage(Context context, String url, ImageView imageView) {
        GlideUtils.loadRoundedImage(context, url, imageView);
    }
}
