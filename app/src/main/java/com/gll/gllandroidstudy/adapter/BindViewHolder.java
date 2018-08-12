package com.gll.gllandroidstudy.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by: Z_B on 2018/8/12.
 * Function: DataBinding 和viewHolder的使用
 */
public class BindViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T mBindIng;

    public BindViewHolder(T binding) {
        super(binding.getRoot());
        mBindIng = binding;
    }

    public T getBind() {
        return mBindIng;
    }

}
