package com.gll.gllandroidstudy.contact;

import com.gll.gllandroidstudy.model.TestBean;
import com.gll.mylibrary.mvpbase.BasePresenter;
import com.gll.mylibrary.mvpbase.BaseView;

import java.util.List;

/**
 * Created by: Z_B on 2018/8/23.
 * Function:
 */
public interface SignInStepViewContact {
    interface view extends BaseView {
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setData(List<TestBean.StoriesBean> dataList);
    }

    interface presenter extends BasePresenter {
        /**
         * 获取数据
         */
        void getData();
    }
}
