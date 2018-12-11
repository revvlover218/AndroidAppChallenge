package com.example.reshal.testapp1;

import android.app.Application;
import android.os.SystemClock;

public class simSplashTime extends Application {

    /*This is just to show the splash screen by simulating
    a cold start of the app..
    * NEVER use this in production*/
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(1000);
    }
}
