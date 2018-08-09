package com.gll.gllandroidstudy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.gll.gllandroidstudy.R;

/**
 * Created by: Z_B on 2018/8/8.
 * Function:
 */
public class RecyclerViewHeaderView extends FrameLayout{
    public RecyclerViewHeaderView(@NonNull Context context) {
        this(context,null);
    }

    public RecyclerViewHeaderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public RecyclerViewHeaderView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View headerView=View.inflate(context, R.layout.include_recyclerview_header_layout,this);



    }
}
