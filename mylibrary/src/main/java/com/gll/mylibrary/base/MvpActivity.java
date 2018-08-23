package com.gll.mylibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gll.mylibrary.mvp.BasePresenter;
import com.gll.mylibrary.rxjava.SubscriptionManager;

/**
 * Created by: Z_B on 2018/8/23.
 * Function:
 */
public abstract class MvpActivity<p extends BasePresenter> extends BaseActivity {

    public p presener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presener = initPresenter();
        //把所有继承此类的Activity都绑定到这里了，这样View就和Present联系起来了。
        presener.addView(this);
    }

    protected abstract p initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presener.detattch();
        //View消除时取消订阅关系
        SubscriptionManager.getInstance().cancelall();
    }

}
