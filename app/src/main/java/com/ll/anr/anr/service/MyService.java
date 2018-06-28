package com.ll.anr.anr.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.e("Ruby","onBind");
        return null;

    }

    @Override
    public void onCreate() {
        Log.e("Ruby","onCreate");
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Ruby","onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Ruby","onUnbind");
        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        Log.e("Ruby","onDestroy");
        super.onDestroy();
    }
}
