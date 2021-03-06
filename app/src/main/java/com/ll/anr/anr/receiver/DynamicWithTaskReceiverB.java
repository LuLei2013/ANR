package com.ll.anr.anr.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class DynamicWithTaskReceiverB extends BroadcastReceiver {
    final static int FIVE_SECONDS = 5 * 1000;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Ruby", "DynamicWithTaskReceiverB onReceive begin");
        try {
            Thread.sleep(FIVE_SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Handler(Looper.getMainLooper()).post(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.e("Ruby", "DynamicWithTaskReceiverB task start");
                        try {
                            Thread.sleep(4 * FIVE_SECONDS);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Log.e("Ruby", "DynamicWithTaskReceiverB task end");
                    }
                }
        );
        Log.e("Ruby", "DynamicWithTaskReceiverB onReceive end");
    }
}
