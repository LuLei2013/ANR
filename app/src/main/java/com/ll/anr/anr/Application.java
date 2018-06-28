package com.ll.anr.anr;


import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

public class Application extends android.app.Application {

    final public static int THREE_SECOND = 3 * 1000;

    static {
        Log.e("Ruby", "Application static init");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Ruby", getProcessName() + "Application  onCreate start");
        if (isBackgroundProcess()) {
            try {
                Thread.sleep(THREE_SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.e("Ruby", getProcessName() + "Application  onCreate end");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.e("Ruby", getProcessName() + "Application  attachBaseContext start");
        if (isBackgroundProcess()) {
            try {
                Thread.sleep(THREE_SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.e("Ruby", getProcessName() + "Application  attachBaseContext end");
    }


    private String getProcessName() {
        String procName = android.os.Process.myPid() + ":";
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                procName += appProcess.processName;
                break;
            }
        }
        return procName;
    }

    private boolean isBackgroundProcess() {
        return getProcessName().contains(":main") || getProcessName().contains(":background");
    }
}