package com.gll.gllandroidstudy.IView;

import com.gll.gllandroidstudy.model.TestBean;
import com.gll.mylibrary.mvpbase.BaseView;

import java.util.List;

/**
 * Created by: Z_B on 2018/8/23.
 * Function:
 */
public interface ISignInStepView extends BaseView {

    void setData(List<TestBean.StoriesBean> dataList);
}
