package com.gll.gllandroidstudy.base;


import android.database.Observable;

import com.gll.gllandroidstudy.model.TestBean;


public interface RetrofitService {


    String BASE_URL = "https://news-at.zhihu.com/api/4/";


    /**
     * 测试接口
     *
     * @return
     */
    @GET("news/latest")
    Observable<TestBean> test();


}