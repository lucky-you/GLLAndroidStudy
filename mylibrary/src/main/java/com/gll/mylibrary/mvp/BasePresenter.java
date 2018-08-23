package com.gll.mylibrary.mvp;

/**
 * Created by: Z_B on 2018/8/23.
 * Function:
 */
public class BasePresenter<V> {
    public V view;

    //加载View,建立连接
    public void addView(V v) {
        this.view = v;
    }

    //断开连接
    public void detattch() {
        if (view != null) {
            view = null;
        }
    }

}
