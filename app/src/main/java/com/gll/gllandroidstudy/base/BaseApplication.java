package com.gll.gllandroidstudy.base;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.bilibili.boxing.BoxingCrop;
import com.bilibili.boxing.BoxingMediaLoader;
import com.bilibili.boxing.loader.IBoxingMediaLoader;
import com.gll.gllandroidstudy.boxing.BoxingGlideLoader;
import com.gll.gllandroidstudy.boxing.BoxingUCrop;

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
        IBoxingMediaLoader loader = new BoxingGlideLoader();
        BoxingMediaLoader.getInstance().init(loader);
        BoxingCrop.getInstance().init(new BoxingUCrop());
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

