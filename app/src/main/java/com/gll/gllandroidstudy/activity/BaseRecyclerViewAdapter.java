package com.gll.gllandroidstudy.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.ImageViewAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.model.ImageBean;
import com.gll.gllandroidstudy.utils.BarUtils;
import com.gll.gllandroidstudy.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseRecyclerViewAdapter extends BaseActivity {

    private RecyclerView publicRecyclerView;
    private ImageViewAdapter imageViewAdapter;
    private Bitmap src;
    private List<ImageBean> mList = new ArrayList<>();

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_base_recycler_view_adapter);
    }

    @Override
    protected void bindViews() {
        initTitle("RecyclerViewAdapter");
        publicRecyclerView = get(R.id.publicRecyclerView);
        LinearLayout llRootLayout = get(R.id.ll_root_layout);
        BarUtils.addMarginTopEqualStatusBarHeight(llRootLayout);
        BarUtils.setStatusBarColor(this, ContextCompat.getColor(BaseApplication.getInstance(), R.color.colorPrimary), 0);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        src = ImageUtils.getBitmap(R.drawable.wall10);
        Bitmap round = ImageUtils.getBitmap(R.drawable.avatar_round);
        Bitmap watermark = ImageUtils.getBitmap(R.mipmap.ic_launcher);

        int width = src.getWidth();
        int height = src.getHeight();

        mList.add(new ImageBean(R.string.image_src, src));
        mList.add(new ImageBean(R.string.image_add_color, ImageUtils.drawColor(src, Color.parseColor("#8000FF00"))));
        mList.add(new ImageBean(R.string.image_scale, ImageUtils.scale(src, width / 2, height / 2)));
        mList.add(new ImageBean(R.string.image_clip, ImageUtils.clip(src, 0, 0, width / 2, height / 2)));
        mList.add(new ImageBean(R.string.image_skew, ImageUtils.skew(src, 0.2f, 0.1f)));
        mList.add(new ImageBean(R.string.image_rotate, ImageUtils.rotate(src, 90, width / 2, height / 2)));
        mList.add(new ImageBean(R.string.image_to_round, ImageUtils.toRound(src)));
        mList.add(new ImageBean(R.string.image_to_round_border, ImageUtils.toRound(src, 16, Color.GREEN)));
        mList.add(new ImageBean(R.string.image_to_round_corner, ImageUtils.toRoundCorner(src, 80)));
        mList.add(new ImageBean(R.string.image_to_round_corner_border, ImageUtils.toRoundCorner(src, 80, 16, Color.GREEN)));
        mList.add(new ImageBean(R.string.image_add_corner_border, ImageUtils.addCornerBorder(src, 16, Color.GREEN, 0)));
        mList.add(new ImageBean(R.string.image_add_circle_border, ImageUtils.addCircleBorder(round, 16, Color.GREEN)));
        mList.add(new ImageBean(R.string.image_add_reflection, ImageUtils.addReflection(src, 80)));
        mList.add(new ImageBean(R.string.image_add_text_watermark, ImageUtils.addTextWatermark(src, "blankj", 40, Color.GREEN, 0, 0)));
        mList.add(new ImageBean(R.string.image_add_image_watermark, ImageUtils.addImageWatermark(src, watermark, 0, 0, 0x88)));
        mList.add(new ImageBean(R.string.image_to_gray, ImageUtils.toGray(src)));
        mList.add(new ImageBean(R.string.image_fast_blur, ImageUtils.fastBlur(src, 0.1f, 5)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mList.add(new ImageBean(R.string.image_render_script_blur, ImageUtils.renderScriptBlur(src, 10)));
        }
        mList.add(new ImageBean(R.string.image_stack_blur, ImageUtils.stackBlur(src, 10)));
        mList.add(new ImageBean(R.string.image_compress_by_scale, ImageUtils.compressByScale(src, 0.5f, 0.5f)));
        mList.add(new ImageBean(R.string.image_compress_by_quality_half, ImageUtils.compressByQuality(src, 50)));
        mList.add(new ImageBean(R.string.image_compress_by_quality_max_size, ImageUtils.compressByQuality(src, 10L * 1024)));// 10Kb
        mList.add(new ImageBean(R.string.image_compress_by_sample_size, ImageUtils.compressBySampleSize(src, 2)));

        imageViewAdapter = new ImageViewAdapter(mList, R.layout.include_simple_item_view_layout);
        publicRecyclerView.setAdapter(imageViewAdapter);
        publicRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

    }

    @Override
    protected void setListener() {

    }
}
