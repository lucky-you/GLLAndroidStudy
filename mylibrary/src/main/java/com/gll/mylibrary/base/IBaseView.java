package com.gll.mylibrary.base;

/**
 * Created by: Z_B on 2018/8/23.
 * Function:
 */
public interface IBaseView {

    //显示loading
    void showLoading();

    //关闭loading
    void closeLoading();

    //显示吐司
    void showToast(String msg);
}
