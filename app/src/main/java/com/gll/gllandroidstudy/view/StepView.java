package com.gll.gllandroidstudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.gll.gllandroidstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Z_B
 * @date : 2018/8/14
 * @function :
 */
public class StepView extends View {


    private Paint mPaint;
    private RectF mBrounds;
    private Context mContext;
    private int strokeWidth = 8; //宽度
    private int strokeHeight = 100;//长度
    private int shapeBackgroundColor = R.color.red_color_df4c56; //背景的颜色

    private List<String> mDateList = new ArrayList<>();


    public StepView(Context context) {
        this(context, null);
    }

    public StepView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StepView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBrounds = new RectF();
    }

    public void setShapeBackgroundColor(int shapeBackgroundColor) {
        this.shapeBackgroundColor = shapeBackgroundColor;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public void setmDateList(List<String> mDateList) {
        this.mDateList = mDateList;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        setStepView(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void setStepView(Canvas canvas) {
//        if (mDateList == null || mDateList.size() < 0) return;
        mPaint.setStrokeWidth(dp2px(strokeWidth));
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(mContext.getResources().getColor(shapeBackgroundColor));
        int width = getWidth();


        canvas.drawLine(dp2px(20), dp2px(20), dp2px(strokeHeight), dp2px(20), mPaint);


    }


    private int dp2px(float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpValue,
                mContext.getResources().getDisplayMetrics());
    }
}
