package com.gll.gllandroidstudy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gll.gllandroidstudy.R;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * author      : Z_B
 * date       : 2019/6/11
 * function  : 九宫格图片
 */
public class LGNineGridView extends ViewGroup {
    private final String TAG = "NineGrideView";
    private final int SINGLE_IMAGE_MODE_RELATIVE_TO_SELF = 1;//单图显示模式:按照原图比例计算高度
    private final int SINGLE_IMAGE_MODE_SPECIFIED_RATIO = 2;//单图显示模式:指定宽高比例
    private final float DEFAULTWIDTHRELATIVETOPARENT = 2 / 3.0f;//单张图片相对总可用宽度的比例
    private float widthRatioToParent = DEFAULTWIDTHRELATIVETOPARENT;
    private int singleImageMode = SINGLE_IMAGE_MODE_SPECIFIED_RATIO;

    private static final int DEFAULT_SPACING = 2;
    private static final int MAX_COUNT = 9;
    private int space = 0;
    private int grideWidth = 0;
    private int grideHeight = 0;
    private final List<String> urls = new ArrayList<>();
    private Context context;
    private int rows;
    private int colums;
    private float singleImageHeightRatio = 1;//单张图片相对自己宽度的比例(默认为1:和宽度相等)

    public LGNineGridView(Context context) {
        this(context, null);
    }

    public LGNineGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LGNineGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    public interface ImageCreator {
        ImageView createImageView(Context context);

        void loadImage(Context context, String url, ImageView imageView);
    }

    public interface OnItemClickListener {
        void onClickItem(int position, View view);
    }

    private ImageCreator imageCreator;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setImageCreator(ImageCreator imageCreator) {
        this.imageCreator = imageCreator;
    }

    private void initView(Context context, AttributeSet attrs) {
        this.context = context;
        int defaultSpace = DensityUtil.dp2px(DEFAULT_SPACING);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LGNineGridView);
        space = (int) typedArray.getDimension(R.styleable.LGNineGridView_space, defaultSpace);
        singleImageHeightRatio = typedArray.getFloat(R.styleable.LGNineGridView_singleImageRatio, DensityUtil.dp2px(1));
        singleImageMode = typedArray.getInteger(R.styleable.LGNineGridView_singleImageRatioMode, SINGLE_IMAGE_MODE_SPECIFIED_RATIO);
        widthRatioToParent = typedArray.getFloat(R.styleable.LGNineGridView_singleImageWidthRatioToParent, DEFAULTWIDTHRELATIVETOPARENT);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (urls == null) {
            setVisibility(GONE);
            return;
        }
        int size = urls.size();
        int sugMinWidth = getSuggestedMinimumWidth();
        int minWidth = getPaddingLeft() + getPaddingRight() + sugMinWidth;
        int totalWidth = resolveSizeAndState(minWidth, widthMeasureSpec, 0);
        int availableWidth = totalWidth - getPaddingLeft() - getPaddingRight();
        if (size == 1) {
            grideWidth = (int) (availableWidth * widthRatioToParent);
            grideHeight = (int) (grideWidth * singleImageHeightRatio);
            if (singleImageMode == SINGLE_IMAGE_MODE_RELATIVE_TO_SELF) {
                ImageView view = (ImageView) getChildAt(0);
                if (view != null) {
                    Rect rect = view.getDrawable().getBounds();
                    int bitmapWidth = rect.width();
                    int bitmapHeight = rect.height();
                    grideWidth = bitmapWidth;
                    grideHeight = bitmapHeight;
                    if (grideWidth >= totalWidth) {
                        grideWidth = totalWidth;
                        grideHeight = grideWidth * bitmapHeight / bitmapWidth;
                    }
                }
            }
        } else {
            grideWidth = (availableWidth - space * (colums - 1)) / 3;
            grideHeight = grideWidth;
        }
        int height = rows * grideHeight + (rows - 1) * space + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(totalWidth, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int size = urls.size();
        if (size == 0)
            return;
        int tmpWidth = grideWidth;
        int tmpHeight = grideHeight;

        int childSize = getChildCount();

        for (int i = 0; i < size; ++i) {
            final String url = urls.get(i);
            final int position = i;
            ImageView view = (ImageView) getChildAt(i);
            if (view == null) {
                if (imageCreator == null) {
                    imageCreator = DefaultImageCreator.getInstance();
                }
                view = imageCreator.createImageView(context);
                addView(view);
                view.setOnClickListener(v -> {
                    if (onItemClickListener != null) {
                        onItemClickListener.onClickItem(position, v);
                    }
                });
            }
            imageCreator.loadImage(context, url, view);
            view.setVisibility(VISIBLE);
            l = i % colums * (tmpWidth + space) + getPaddingLeft();
            t = i / colums * (tmpHeight + space) + getPaddingTop();
            r = l + tmpWidth;
            b = t + tmpHeight;
            view.layout(l, t, r, b);
        }
        if (size < childSize) {
            for (int i = size; i < childSize; ++i) {
                ImageView view = (ImageView) getChildAt(i);
                view.setVisibility(GONE);
            }
        }
    }

    private void initRowAndColum(int size) {
        rows = (size - 1) / 3 + 1;
        colums = (size - 1) % 3 + 1;
        if (size == 4) {
            rows = 2;
            colums = 2;
            return;
        } else {
            colums = 3;
        }
    }

    public void setUrls(List<String> urls) {
        if (urls == null || urls.isEmpty()) {
            setVisibility(GONE);
            return;
        }
        setVisibility(VISIBLE);
        if (this.urls == urls) {
            return;
        }
        this.urls.clear();
        this.urls.addAll(urls);
        initRowAndColum(urls.size());
        requestLayout();
    }

}
