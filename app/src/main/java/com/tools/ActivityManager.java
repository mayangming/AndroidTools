package com.tools;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.util.Stack;

/**
 * Activity管理
 */
public class ActivityManager implements Application.ActivityLifecycleCallbacks{
    private  Stack<Activity> store;
    private int appCount = 0;
    private boolean isForground = true;
    private static ActivityManager activityManager = new ActivityManager();

    public static ActivityManager getInstance(){
        return activityManager;
    }

    private ActivityManager() {
    }

    public Stack<Activity> getStore() {
        return store;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        store.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        appCount++;
        if (!isForground) {
            isForground = true;
            Log.e("AppLifecycle", "app into forground ");
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
        appCount--;
        if (!isForgroundAppValue()) {
            isForground = false;
            Log.e("AppLifecycle", "app into background ");
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        store.remove(activity);
    }
    private boolean isForgroundAppValue() {
        return appCount > 0;
    }

    /**
     * 是否是前台
     * @return true:前台 false：后台
     */
    public boolean isForground(){
        return isForground;
    }

}