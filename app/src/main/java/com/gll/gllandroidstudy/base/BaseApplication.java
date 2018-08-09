package com.gll.gllandroidstudy.base;

import android.app.Application;

/**
 * Created by : Z_B on 2018/1/23.
 * Effect :  application
 */

public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }



    public static BaseApplication getInstance() {
        return baseApplication;
    }


}

