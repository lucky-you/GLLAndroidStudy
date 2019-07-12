package com.gll.gllandroidstudy.Index;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;

/**
 * Created by : Z_B on 2019/7/12.
 * describe：右侧的索引
 */
public class IndexSideBarView extends View {
    private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    public String[] baseIndex = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    private int choose = -1;
    private Paint paint = new Paint();
    private TextView mTextDialog;
    private int mTextColor = Color.parseColor("#666666");
    private int mSelectTextColor = Color.parseColor("#3399ff");

    public void setTextView(TextView mTextDialog) {
        this.mTextDialog = mTextDialog;
    }

    public IndexSideBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public IndexSideBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IndexSideBarView(Context context) {
        super(context);
    }

    public void setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public void setSelectTextColor(int mSelectTextColor) {
        this.mSelectTextColor = mSelectTextColor;
    }

    public void setBaseIndex(String[] aZSet) {
        if (aZSet != null) {
            this.baseIndex = aZSet;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = this.getHeight();
        int width = this.getWidth();
        int singleHeight = height / this.baseIndex.length;
        for (int i = 0; i < this.baseIndex.length; ++i) {
            this.paint.setColor(this.mTextColor);
            this.paint.setTypeface(Typeface.DEFAULT_BOLD);
            this.paint.setAntiAlias(true);
            this.paint.setTextSize((float) this.sp2px(14.0F));
            if (i == this.choose) {
                this.paint.setColor(this.mSelectTextColor);
                this.paint.setFakeBoldText(true);
            }
            float xPos = (float) (width / 2) - this.paint.measureText(this.baseIndex[i]) / 2.0F;
            float yPos = (float) (singleHeight * i + singleHeight);
            canvas.drawText(this.baseIndex[i], xPos, yPos, this.paint);
            this.paint.reset();
        }

    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float y = event.getY();
        int oldChoose = this.choose;
        OnTouchingLetterChangedListener listener = this.onTouchingLetterChangedListener;
        int c = (int) (y / (float) this.getHeight() * (float) this.baseIndex.length);
        switch (action) {
            case 1:
                this.setBackgroundDrawable(new ColorDrawable(0));
                this.choose = -1;
                this.invalidate();
                if (this.mTextDialog != null) {
                    this.mTextDialog.setVisibility(4);
                }
                break;
            default:
                this.setBackgroundResource(R.drawable.sidebar_background);
                if (oldChoose != c && c >= 0 && c < this.baseIndex.length) {
                    if (listener != null) {
                        listener.onTouchingLetterChanged(this.baseIndex[c]);
                    }
                    if (this.mTextDialog != null) {
                        this.mTextDialog.setText(this.baseIndex[c]);
                        this.mTextDialog.setVisibility(0);
                    }
                    this.choose = c;
                    this.invalidate();
                }
        }
        return true;
    }

    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    public int sp2px(float spValue) {
        float fontScale = this.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5F);
    }
}
