package com.ll.anr.anr.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DynamicReceiver extends BroadcastReceiver {
    final static int ONE_HUNDRED_SECONDS = 100 * 1000;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Ruby", "DynamicReceiver onReceive begin");
        try {
            Thread.sleep(ONE_HUNDRED_SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("Ruby", "DynamicReceiver onReceive end");
    }
}
