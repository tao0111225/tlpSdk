package com.tlp.dreams.basesdk.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.LinkedList;

/**
 * author  ：tlp
 * create  ： 16/8/4
 * email   ：18772115876@163.com
 * content ：
 */
public class GlobalApplication extends Application {

    private static GlobalApplication sInstance;

    //双向链表
    private LinkedList<Activity> mActivities = new LinkedList<>();


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static GlobalApplication getInstance() {
        if (sInstance == null) {
            sInstance = new GlobalApplication();
        }
        return sInstance;
    }

    public static Context getContext() {
        return getContext();
    }


    public void addActivity(Activity activity) {
        if (activity != null) {
            mActivities.add(activity);
        }
    }


    public void removeActivity(Activity activity) {
        if (activity != null) {
            mActivities.remove(activity);
        }
    }
}
