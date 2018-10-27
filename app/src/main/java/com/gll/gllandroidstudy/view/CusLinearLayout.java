package com.gll.gllandroidstudy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.TimeAndStatus;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/10/27
 * function  : 自定义的LinearLayout
 */
public class CusLinearLayout extends LinearLayout {

    private TextView tvTime;
    private TextView tvStatus;
    private ImageView ivBottom;


    public CusLinearLayout(Context context) {
        this(context, null);
    }

    public CusLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CusLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View itemView = View.inflate(context, R.layout.include_second_kill_good_title, this);
        tvTime = itemView.findViewById(R.id.tv_second_kill_good_time);
        tvStatus = itemView.findViewById(R.id.tv_second_kill_good_status);
        ivBottom = itemView.findViewById(R.id.tv_second_kill_good_imageView);
    }


    public void setCustomDate(TimeAndStatus customDate) {
        tvTime.setText(customDate.getTime());
        tvStatus.setText(customDate.getStatus());
    }

}
