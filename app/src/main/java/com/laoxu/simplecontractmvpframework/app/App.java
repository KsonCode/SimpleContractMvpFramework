package com.laoxu.simplecontractmvpframework.app;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
