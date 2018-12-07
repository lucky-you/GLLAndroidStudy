package com.gll.gllandroidstudy.nineimage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * author      : Z_B
 * date       : 2018/12/7
 * function  :
 */
public class NineHeightWrapGridView extends GridView {
    public NineHeightWrapGridView(Context context) {
        this(context,null);
    }

    public NineHeightWrapGridView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.gridViewStyle);
    }

    public NineHeightWrapGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSelector(android.R.color.transparent);
        setOverScrollMode(OVER_SCROLL_NEVER);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
