package com.gll.gllandroidstudy.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.gll.gllandroidstudy.R;


/**
 * Created by：Z_B on 2018/4/20 09:50
 * Effect： 自定义倒计时控件
 */
public class CustomCountDownTimerView extends View {

    //背景画笔
    private Paint mPaint;

    //进度条的画笔
    private Paint progressPaint;

    //文本的画笔
    private Paint textPaint;

    //圆环的颜色
    private int roundColor;

    //圆环进度的颜色
    private int roundProgressColor;

    //中间进度百分比的字符串的颜色
    private int textColor;

    //中间进度百分比的字符串的字体
    private float textSize;

    //  圆环的宽度
    private float roundWidth;

    //倒计时时间
    private int mCountdownTime;

    //圆环的矩形区域
    private RectF mRectF;

    //当前的进度
    private float mCurrentProgress;

    //宽度
    private int mWidth;
    //高度
    private int mHeight;
    public OnCountDownTimeFinishListener onCountDownTimeFinishListener;
    private ValueAnimator valueAnimator;

    private String currentTextTime;

    public CustomCountDownTimerView(Context context) {
        this(context, null);
    }

    public CustomCountDownTimerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomCountDownTimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCountDownTimerView);
        roundColor = mTypedArray.getColor(R.styleable.CustomCountDownTimerView_cus_roundColor, context.getResources().getColor(R.color.theme_color));
        roundProgressColor = mTypedArray.getColor(R.styleable.CustomCountDownTimerView_cus_roundProgressColor, context.getResources().getColor(R.color.background_color));
        textColor = mTypedArray.getColor(R.styleable.CustomCountDownTimerView_cus_textColor, context.getResources().getColor(R.color.red_color_df4c56));
        textSize = mTypedArray.getDimension(R.styleable.CustomCountDownTimerView_cus_textSize, 15);
        roundWidth = mTypedArray.getDimension(R.styleable.CustomCountDownTimerView_cus_roundWidth, 6);
        mCountdownTime = mTypedArray.getInteger(R.styleable.CustomCountDownTimerView_cus_countdownTime, 10);
        mTypedArray.recycle();

        //背景
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);

        //进度条
        progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progressPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);

        //文本
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        mRectF = new RectF(0 + roundWidth / 2, 0 + roundWidth / 2,
                mWidth - roundWidth / 2, mHeight - roundWidth / 2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制外层大圆环
        int centre = getWidth() / 2; //获取圆心的x坐标
        int radius = (int) (centre - roundWidth / 2); //圆环的半径
        mPaint.setColor(roundColor); //设置圆环的颜色
        mPaint.setStyle(Paint.Style.STROKE); //设置空心
        mPaint.setStrokeWidth(roundWidth); //设置圆环的宽度
        mPaint.setAntiAlias(true);  //消除锯齿
        canvas.drawCircle(centre, centre, radius, mPaint); //画出圆环

        progressPaint.setColor(roundProgressColor);
        //空心
        progressPaint.setStyle(Paint.Style.STROKE);
        //宽度
        progressPaint.setStrokeWidth(roundWidth);
        canvas.drawArc(mRectF, -90, mCurrentProgress - 360, false, progressPaint);

        //绘制文本
//        currentTextTime = mCountdownTime - (int) (mCurrentProgress / 360f * mCountdownTime) + "s";
//        textPaint.setTextSize(textSize);
//        textPaint.setColor(textColor);
//        //文字居中显示
//        Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();
//        int baseline = (int) ((mRectF.bottom + mRectF.top - fontMetrics.bottom - fontMetrics.top) / 2);
//        canvas.drawText(currentTextTime, mRectF.centerX(), baseline, textPaint);


    }

    /**
     * 设置倒计时时间
     */
    public void setCountdownTime(int mCountdownTime) {
        this.mCountdownTime = mCountdownTime;
    }

    private ValueAnimator getValA(long countdownTime) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100);
        valueAnimator.setDuration(countdownTime);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(0);
        return valueAnimator;
    }

    /**
     * 开始倒计时
     */
    public void startCountDown() {
        stopAnimator();
        setClickable(false);
        valueAnimator = getValA(mCountdownTime * 1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float i = Float.valueOf(String.valueOf(animation.getAnimatedValue()));
                mCurrentProgress = (int) (360 * (i / 100f));
                invalidate();
            }
        });
        valueAnimator.start();
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //倒计时结束回调
                if (onCountDownTimeFinishListener != null && valueAnimator != null) {
                    onCountDownTimeFinishListener.countDownFinished();
                }
                setClickable(true);
            }
        });

    }

    /**
     * 得到当前进度
     */
    public float getCurrentProgress() {
        if (mCurrentProgress != 0) {
            return mCurrentProgress;
        }
        return mCurrentProgress;

    }

    public void pauseCountDown() {
        setClickable(false);
        if (valueAnimator != null) {
            ValueAnimator valueAnimator = this.valueAnimator;
            this.valueAnimator = null;
            valueAnimator.pause();
        }
    }


    @Override
    protected void onDetachedFromWindow() {
        stopAnimator();
        super.onDetachedFromWindow();
    }

    private void stopAnimator() {
        if (valueAnimator != null) {
            ValueAnimator valueAnimator = this.valueAnimator;
            this.valueAnimator = null;
            valueAnimator.cancel();
        }
    }

    /**
     * 设置监听
     */
    public void setOnCountDownTimeFinishListener(OnCountDownTimeFinishListener onCountDownTimeFinishListener) {
        this.onCountDownTimeFinishListener = onCountDownTimeFinishListener;
    }

    /**
     * 倒计时结束的监听
     */
    public interface OnCountDownTimeFinishListener {

        void countDownFinished(); //结束

    }

    public void setRoundWidth(float roundWidth) {
        this.roundWidth = roundWidth;
    }

    public void setRoundColor(int roundColor) {
        this.roundColor = roundColor;
    }

    public void setRoundProgressColor(int roundProgressColor) {
        this.roundProgressColor = roundProgressColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }
}
