package com.basics.common;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

/**
 * @CreateDate: 2020-03-23 15:41
 * @Version: 1.0
 * @Description: java类作用描述
 * @Author: xueshijie
 */
public class BaseApplication extends Application {


    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getContext() {
        return application;
    }
}
