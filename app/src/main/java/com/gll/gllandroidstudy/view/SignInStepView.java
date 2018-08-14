package com.gll.gllandroidstudy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


import com.gll.gllandroidstudy.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author : Z_B
 * @date : 2018/8/14
 * @function : 签到流程的view
 */
public class SignInStepView extends View {


    private static final int START_STEP = 1;
    private int mCurrentStep = START_STEP;
    private int mCircleColor;
    private int mTextColor;
    private int mSelectedColor;
    private int mFillRadius;
    private int mStrokeWidth;
    private int mLineWidth;
    private int mDrawablePadding;
    private Paint mPaint;

    private final List<String> mSteps = new ArrayList<>();


    public SignInStepView(Context context) {
        this(context, null);
    }

    public SignInStepView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInStepView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SignInStepView);
        mCircleColor = typedArray.getColor(R.styleable.SignInStepView_svCircleColor, 0);
        mTextColor = typedArray.getColor(R.styleable.SignInStepView_svTextColor, 0);
        mSelectedColor = typedArray.getColor(R.styleable.SignInStepView_svSelectedColor, 0);
        mFillRadius = typedArray.getDimensionPixelSize(R.styleable.SignInStepView_svFillRadius, 0);
        mStrokeWidth = typedArray.getDimensionPixelSize(R.styleable.SignInStepView_svStrokeWidth, 0);
        mLineWidth = typedArray.getDimensionPixelSize(R.styleable.SignInStepView_svLineWidth, 0);
        mDrawablePadding = typedArray.getDimensionPixelSize(R.styleable.SignInStepView_svDrawablePadding, 0);
        final int textSize = typedArray.getDimensionPixelSize(R.styleable.SignInStepView_svTextSize, 0);
        typedArray.recycle();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setTextSize(textSize);
        mPaint.setTextAlign(Paint.Align.CENTER);


        if (isInEditMode()) {
            String[] steps = {"今天", "明天", "后天"};
            setSteps(Arrays.asList(steps));
        }

    }


    public void setSteps(List<String> steps) {
        mSteps.clear();
        if (steps != null) {
            mSteps.addAll(steps);
        }
        selectedStep(START_STEP);
    }

    public void selectedStep(int step) {
        final int selected = step < START_STEP ?
                START_STEP : (step > mSteps.size() ? mSteps.size() : step);
        mCurrentStep = selected;
        invalidate();
    }

    public int getCurrentStep() {
        return mCurrentStep;
    }

    public int getStepCount() {
        return mSteps.size();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (heightMode == MeasureSpec.AT_MOST) {
            final int fontHeight = (int) Math.ceil(mPaint.descent() - mPaint.ascent());
            height = getPaddingTop() + getPaddingBottom() + (mFillRadius + mStrokeWidth) * 2
                    + mDrawablePadding + fontHeight;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final int stepSize = mSteps.size();
        if (stepSize == 0) {
            return;
        }
        final int width = getWidth();

        final float ascent = mPaint.ascent();
        final float descent = mPaint.descent();
        final int fontHeight = (int) Math.ceil(descent - ascent);
        final int halfFontHeightOffset = -(int) (ascent + descent) / 2;
        final int bigRadius = mFillRadius + mStrokeWidth;
        final int startCircleY = getPaddingTop() + bigRadius;
        final int childWidth = width / stepSize;

        //画节点
        for (int i = 1; i <= stepSize; i++) {
            drawableStep(canvas, i, halfFontHeightOffset, fontHeight, bigRadius,
                    childWidth * i - childWidth / 2, startCircleY);
        }

        final int halfLineLength = childWidth / 2 - bigRadius;


        //画线
        for (int i = 1; i < stepSize; i++) {
            final int lineCenterX = childWidth * i;
            drawableLine(canvas, lineCenterX - halfLineLength,
                    lineCenterX + halfLineLength, startCircleY);
        }
    }

    private void drawableStep(Canvas canvas, int step, int halfFontHeightOffset, int fontHeight,
                              int bigRadius, int circleCenterX, int circleCenterY) {
        final String text = mSteps.get(step - 1);
        final boolean isSelected = step == mCurrentStep;

        if (isSelected) {
            mPaint.setStrokeWidth(mStrokeWidth);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(mCircleColor);
            canvas.drawCircle(circleCenterX, circleCenterY, mFillRadius + mStrokeWidth / 2, mPaint);

            mPaint.setColor(mSelectedColor);
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(circleCenterX, circleCenterY, mFillRadius, mPaint);
        } else {
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(mCircleColor);
            canvas.drawCircle(circleCenterX, circleCenterY, bigRadius, mPaint);
        }

        mPaint.setFakeBoldText(true);
        mPaint.setColor(Color.WHITE);
        String number = String.valueOf(step);
        canvas.drawText(number, circleCenterX, circleCenterY + halfFontHeightOffset, mPaint);

        mPaint.setFakeBoldText(false);
        mPaint.setColor(isSelected ? mSelectedColor : mTextColor);
        canvas.drawText(text, circleCenterX,
                circleCenterY + bigRadius + mDrawablePadding + fontHeight / 2, mPaint);
    }

    private void drawableLine(Canvas canvas, int startX, int endX, int centerY) {
        mPaint.setColor(mCircleColor);
        mPaint.setStrokeWidth(mLineWidth);
        canvas.drawLine(startX, centerY, endX, centerY, mPaint);
    }

}
