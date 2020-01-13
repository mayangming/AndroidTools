package com.tools;

import android.app.Application;

public class ToolsApplication extends Application {
    private static ToolsApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    public static ToolsApplication getInstance() {
        return instance;
    }

    private void init() {
        registerActivityLifecycleCallbacks(ActivityManager.getInstance());
    }

}