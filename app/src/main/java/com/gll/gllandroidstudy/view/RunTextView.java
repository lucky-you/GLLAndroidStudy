package com.gll.gllandroidstudy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/31.
 * user: Administrator
 * date: 2018/12/31
 * time; 16:35
 * name: net.zhiyuan51.dev.android.getphoneimage.run
 */
public class RunTextView extends View {
    Paint paint;
    int dx;
    boolean isFirst = true;
    String str;
    List<String> text;
    ValueAnimator animator;

    public RunTextView(Context context) {
        super(context);
    }

    public RunTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.RED);
        str = "123456";
        text = new ArrayList<>();
        text.add(str);
    }

    public void setText(String text) {
        if (TextUtils.isEmpty(text)) return;
        setVisibility(VISIBLE);
        this.str = text;
        isFirst = true;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isFirst) {
            startAnim();
            isFirst = false;
        }
        canvas.drawText(str, getWidth() - dx - getTextWidth(paint, str), getHeight() / 2, paint);
    }

    public static int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }

    public void startAnim() {
        animator = ValueAnimator.ofInt(0, getWidth());
        animator.setDuration(10000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.RESTART);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("ValueAnimator", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("ValueAnimator", "onAnimationEnd");
                setVisibility(GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("ValueAnimator", "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("ValueAnimator", "onAnimationRepeat");
                animation.cancel();
            }
        });
        animator.start();
    }
}
