package com.gll.gllandroidstudy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * author      : Z_B
 * date       : 2018/10/18
 * function  : 垂直滚动的RecyclerView
 */
public class AutoScrollRecyclerView extends RecyclerView {
    private Disposable mAutoTask;


    public AutoScrollRecyclerView(Context context) {
        super(context);
    }

    public AutoScrollRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void start() {
        if (mAutoTask != null && !mAutoTask.isDisposed()) {
            mAutoTask.dispose();
        }
        mAutoTask = Observable.interval(1000, 100, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        AutoScrollRecyclerView.this.smoothScrollBy(0, 20);
                    }
                });
    }

    public final void stop() {
        if (mAutoTask != null && !mAutoTask.isDisposed()) {
            mAutoTask.dispose();
            mAutoTask = null;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return true;
    }
}
