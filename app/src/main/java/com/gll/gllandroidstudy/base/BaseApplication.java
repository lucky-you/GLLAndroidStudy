package com.gll.gllandroidstudy.base;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.gll.gllandroidstudy.db.manager.DBManager;


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
        DBManager.initDao();
    }


    public static BaseApplication getInstance() {
        return baseApplication;
    }


    /**
     * 获取版本号
     *
     * @return
     */
    public static int getAppVersionCode() {
        Context context = getInstance();
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}

