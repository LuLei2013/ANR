package com.ll.anr.anr.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.ll.anr.anr.MainActivity;
import com.ll.anr.anr.R;

public class MyService extends Service {


    final static private int SECOND = 1000;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.e("Ruby", "onBind start");
        sleep30();
        Log.e("Ruby", "onBind end");
        return null;

    }

    @Override
    public void onCreate() {
        setForeGroundService();
        Log.e("Ruby", "onCreate start");
        sleep30();
        Log.e("Ruby", "onCreate end");
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Ruby", "onStartCommand start");
        sleep30();
        Log.e("Ruby", "onStartCommand end");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Ruby", "onUnbind start");
        sleep30();
        Log.e("Ruby", "onUnbind end");
        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        Log.e("Ruby", "onDestroy start");
        sleep30();
        Log.e("Ruby", "onDestroy end");
        super.onDestroy();
    }

    private void sleep30() {
        try {
            Thread.sleep(40 * SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setForeGroundService() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("通知")
                .setContentText("前台Service");
        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        mBuilder.setContentIntent(resultPendingIntent);
        Notification notification = mBuilder.build();
        notification.defaults = Notification.DEFAULT_SOUND;
        //前台 service
        startForeground(1, notification);
    }
}
