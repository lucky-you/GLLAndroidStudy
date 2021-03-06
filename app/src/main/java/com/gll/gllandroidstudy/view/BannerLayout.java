package com.gll.gllandroidstudy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.gll.gllandroidstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author      : Z_B
 * date       : 2019/4/28
 * function  : 自定义banner
 */
public class BannerLayout extends LinearLayout {

    private ViewPager bannerViewPager;
    private LinearLayout bannerPointLayout;
    private int mPosition = 0;
    private int mBannerCount = 1;
    private Context context;
    private int bannerPointSize = 10;
    private int bannerPointGravity = Gravity.CENTER;
    private int bannerPointDrawableSelected, bannerPointDrawableUnselected;
    private int bannerDelaySecond = 5;
    private OnBannerClickListener onBannerClickListener;
    private Handler handler = new Handler();
    private Runnable runnable;

    public BannerLayout(Context context) {
        this(context, null);
    }

    public BannerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public BannerLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BannerLayout);
        bannerPointSize = typedArray.getDimensionPixelSize(R.styleable.BannerLayout_bannerPointSize, dp2px(10));
        bannerPointGravity = typedArray.getInt(R.styleable.BannerLayout_bannerPointGravity, Gravity.CENTER);
        bannerDelaySecond = typedArray.getInt(R.styleable.BannerLayout_bannerDelaySecond, 3);
        bannerPointDrawableSelected = typedArray.getResourceId(R.styleable.BannerLayout_bannerPointDrawableSelected, R.drawable.shape_circle_red_bg);
        bannerPointDrawableUnselected = typedArray.getResourceId(R.styleable.BannerLayout_bannerPointDrawableUnselected, R.drawable.shape_circle_grey_bg);
        typedArray.recycle();
        View view = View.inflate(context, R.layout.custom_banner_layout, null);
        addView(view);
        bannerViewPager = (ViewPager) view.findViewById(R.id.bannerViewPager);
        bannerPointLayout = (LinearLayout) view.findViewById(R.id.bannerPointLayout);
        bannerPointLayout.setGravity(bannerPointGravity);
    }

    public void start(List<String> bannerList) {
        bannerShutdown();
        mBannerCount = bannerList.size();
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter(context, bannerList);
        bannerViewPager.setAdapter(bannerPagerAdapter);
        bannerViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                addPointLayout(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == 1) {
                    //手动拖动，移除定时
                    bannerShutdown();
                } else {
                    bannerStart();
                }
            }
        });
        addPointLayout(0);
        bannerStart();
    }

    private void addPointLayout(int position) {
        if (mBannerCount == 1) {
            bannerPointLayout.setVisibility(GONE);
        } else {
            bannerPointLayout.setVisibility(VISIBLE);
            bannerPointLayout.removeAllViews();
            for (int i = 0; i < mBannerCount; i++) {
                ImageView imageView = new ImageView(context);
                LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(10, 0, 0, 10);
                imageView.setLayoutParams(layoutParams);
                if (position == i) {
                    imageView.setImageResource(bannerPointDrawableSelected);
                } else {
                    imageView.setImageResource(bannerPointDrawableUnselected);
                }
                bannerPointLayout.addView(imageView);
            }
        }
    }

    public void bannerStart() {
        if (runnable == null) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    mPosition = bannerViewPager.getCurrentItem();
                    if (mPosition < mBannerCount - 1) {
                        mPosition++;
                    } else {
                        mPosition = 0;
                    }
                    bannerViewPager.setCurrentItem(mPosition);
                    handler.postDelayed(this, bannerDelaySecond * 1000);
                }
            };
            handler.postDelayed(runnable, bannerDelaySecond * 1000);
        }
    }

    public void bannerShutdown() {
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
            runnable = null;
        }
    }

    private class BannerPagerAdapter extends PagerAdapter {
        private List<String> bannerList = new ArrayList<>();
        private Context context;

        BannerPagerAdapter(Context context, List<String> bannerList) {
            this.context = context;
            this.bannerList.clear();
            this.bannerList.addAll(bannerList);
        }

        @Override
        public int getCount() {
            return bannerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            String object = bannerList.get(position);
            Glide.with(context).load(object).into(imageView);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onBannerClickListener != null) {
                        onBannerClickListener.onBannerClick(position);
                    }
                }
            });
            container.addView(imageView, layoutParams);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    public interface OnBannerClickListener {
        void onBannerClick(int position);
    }

    public int dp2px(float var0) {
        float var1 = context.getResources().getDisplayMetrics().density;
        return (int) (var0 * var1 + 0.5F);
    }

    public BannerLayout setBannerPointSize(int bannerPointSize) {
        this.bannerPointSize = dp2px(bannerPointSize);
        return this;
    }

    public BannerLayout setBannerPointGravity(int bannerPointGravity) {
        this.bannerPointGravity = bannerPointGravity;
        bannerPointLayout.setGravity(bannerPointGravity);
        return this;
    }

    public BannerLayout setBannerPointDrawableSelected(int bannerPointDrawableSelected) {
        this.bannerPointDrawableSelected = bannerPointDrawableSelected;
        return this;
    }

    public BannerLayout setBannerPointDrawableUnselected(int bannerPointDrawableUnselected) {
        this.bannerPointDrawableUnselected = bannerPointDrawableUnselected;
        return this;
    }

    public BannerLayout setBannerDelaySecond(int bannerDelaySecond) {
        this.bannerDelaySecond = bannerDelaySecond;
        return this;
    }

    public BannerLayout setOnBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.onBannerClickListener = onBannerClickListener;
        return this;
    }
}


