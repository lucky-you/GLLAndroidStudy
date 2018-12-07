package com.gll.gllandroidstudy.nineimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.utils.ScreenUtils;
import com.gll.gllandroidstudy.utils.SizeUtils;

/**
 * author      : Z_B
 * date       : 2018/12/7
 * function  : 九宫格图片展示的控件
 */
public class NineImageViewLayout extends FrameLayout implements View.OnClickListener {

    private static final int ITEM_NUM_COLUMNS = 3;
    private NineImageView mPhotoIv;
    private NineHeightWrapGridView mPhotoGv;
    private int mCurrentClickItemPosition;
    private int mItemCornerRadius;
    private boolean mShowAsLargeWhenOnlyOne;
    private int mItemWhiteSpacing;
    private int mOtherWhiteSpacing;
    private int mPlaceholderDrawableResId;
    private int mItemSpanCount;
    private int mItemWidth;

    public NineImageViewLayout(@NonNull Context context) {
        this(context, null);
    }

    public NineImageViewLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NineImageViewLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDefaultAttrs();
        initCustomAttrs(context, attrs);
        afterInitDefaultAndCustomAttrs();
    }

    private void initDefaultAttrs() {
        mItemWidth = 0;
        mShowAsLargeWhenOnlyOne = true;
        mItemCornerRadius = 0;
        mItemWhiteSpacing = SizeUtils.dp2px(4);
        mPlaceholderDrawableResId = R.drawable.ic_boxing_default_image;
        mOtherWhiteSpacing = SizeUtils.dp2px(100);
        mItemSpanCount = 3;
    }

    private void initCustomAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NineImageViewLayout);
        final int N = typedArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            initCustomAttr(typedArray.getIndex(i), typedArray);
        }
        typedArray.recycle();
    }

    private void initCustomAttr(int attr, TypedArray typedArray) {
        if (attr == R.styleable.NineImageViewLayout_niv_showAsLargeWhenOnlyOne) {
            mShowAsLargeWhenOnlyOne = typedArray.getBoolean(attr, mShowAsLargeWhenOnlyOne);
        } else if (attr == R.styleable.NineImageViewLayout_niv_itemCornerRadius) {
            mItemCornerRadius = typedArray.getDimensionPixelSize(attr, mItemCornerRadius);
        } else if (attr == R.styleable.NineImageViewLayout_niv_itemWhiteSpacing) {
            mItemWhiteSpacing = typedArray.getDimensionPixelSize(attr, mItemWhiteSpacing);
        } else if (attr == R.styleable.NineImageViewLayout_niv_otherWhiteSpacing) {
            mOtherWhiteSpacing = typedArray.getDimensionPixelOffset(attr, mOtherWhiteSpacing);
        } else if (attr == R.styleable.NineImageViewLayout_niv_placeholderDrawable) {
            mPlaceholderDrawableResId = typedArray.getResourceId(attr, mPlaceholderDrawableResId);
        } else if (attr == R.styleable.NineImageViewLayout_niv_itemWidth) {
            mItemWidth = typedArray.getDimensionPixelSize(attr, mItemWidth);
        } else if (attr == R.styleable.NineImageViewLayout_niv_itemSpanCount) {
            mItemSpanCount = typedArray.getInteger(attr, mItemSpanCount);
        }
    }

    private void afterInitDefaultAndCustomAttrs() {
        if (mItemWidth == 0) {
            mItemWidth = (ScreenUtils.getScreenWidth() - mOtherWhiteSpacing - (mItemSpanCount - 1) * mItemWhiteSpacing) / mItemSpanCount;
        }

        mPhotoIv = new NineImageView(getContext());
        mPhotoIv.setClickable(true);
        mPhotoIv.setOnClickListener(this);

        mPhotoGv = new NineHeightWrapGridView(getContext());
        mPhotoGv.setHorizontalSpacing(mItemWhiteSpacing);
        mPhotoGv.setVerticalSpacing(mItemWhiteSpacing);
        mPhotoGv.setNumColumns(ITEM_NUM_COLUMNS);
//        mPhotoGv.setOnItemClickListener(this);
//        mPhotoAdapter = new PhotoAdapter(getContext());
//        mPhotoGv.setAdapter(mPhotoAdapter);
        addView(mPhotoIv, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        addView(mPhotoGv);
    }

    @Override
    public void onClick(View v) {

    }
}
