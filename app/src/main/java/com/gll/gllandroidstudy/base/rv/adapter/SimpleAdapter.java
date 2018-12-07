package com.gll.gllandroidstudy.base.rv.adapter;

import android.support.annotation.LayoutRes;

import java.util.List;

/**
 */
public abstract class SimpleAdapter<M> extends BaseAdapter<M> {

    private final int mLayoutId;

    public SimpleAdapter(List<M> list, @LayoutRes int layoutId) {
        setData(list);
        mLayoutId = layoutId;
    }

    @Override
    protected int bindLayout(final int viewType) {
        return mLayoutId;
    }

}
