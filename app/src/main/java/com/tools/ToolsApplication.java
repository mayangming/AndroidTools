package com.tools;

import android.app.Application;

public class ToolsApplication extends Application {
    private static ToolsApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static ToolsApplication getInstance() {
        return instance;
    }
}