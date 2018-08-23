package com.gll.mylibrary.rxjava;

import io.reactivex.disposables.Disposable;

/**
 * Created by: Z_B on 2018/8/23.
 * Function:
 */
public interface SubscriptionHelper <T>  {
    void add(Disposable subscription);

    void cancel(Disposable t);

    void cancelall();
}
