package com.ll.anr.anr;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ll.anr.anr.receiver.DynamicReceiver;
import com.ll.anr.anr.receiver.DynamicWithTaskReceiverA;
import com.ll.anr.anr.receiver.DynamicWithTaskReceiverB;
import com.ll.anr.anr.receiver.StaticReceiver;

import static android.content.Intent.FLAG_RECEIVER_FOREGROUND;

public class TestBroadcastActivity extends AppCompatActivity {
    private static final String DYNAMIC_ACTION = "com.ll.anr";
    private static final String DYNAMIC_ACTION_TIMEOUT = "com.ll.anr.timeout";
    private static final String DYNAMIC_PERMISSION = "com.ll.anr.anr.permission.TEST_ANR";

    private BroadcastReceiver mDynamicParaReceiver = new DynamicReceiver();

    private BroadcastReceiver mDynamicOrderReceiver = new DynamicReceiver();

    private BroadcastReceiver mDynamicOrderTaskReceiverA = new DynamicWithTaskReceiverA();

    private BroadcastReceiver mDynamicOrderTaskReceiverB = new DynamicWithTaskReceiverB();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_receiver);
        registerReceiver(mDynamicParaReceiver, new IntentFilter(DYNAMIC_ACTION));
        registerReceiver(mDynamicOrderReceiver, new IntentFilter(DYNAMIC_ACTION), DYNAMIC_PERMISSION, null);
        registerReceiver(mDynamicOrderTaskReceiverA, new IntentFilter(DYNAMIC_ACTION_TIMEOUT), DYNAMIC_PERMISSION, null);
        registerReceiver(mDynamicOrderTaskReceiverB, new IntentFilter(DYNAMIC_ACTION_TIMEOUT), DYNAMIC_PERMISSION, null);

        findViewById(R.id.dynamic_order_bf).setOnClickListener(mOnclickListener);
        findViewById(R.id.dynamic_order_bg).setOnClickListener(mOnclickListener);
        findViewById(R.id.dynamic_para_bf).setOnClickListener(mOnclickListener);
        findViewById(R.id.dynamic_para_bg).setOnClickListener(mOnclickListener);
        findViewById(R.id.static_order_bf).setOnClickListener(mOnclickListener);
        findViewById(R.id.static_order_bg).setOnClickListener(mOnclickListener);
        findViewById(R.id.dynamic_order_bg_timeout).setOnClickListener(mOnclickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mDynamicParaReceiver);
        unregisterReceiver(mDynamicOrderReceiver);
        unregisterReceiver(mDynamicOrderTaskReceiverA);
        unregisterReceiver(mDynamicOrderTaskReceiverB);
    }

    private View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.dynamic_order_bf:
                    intent = new Intent(DYNAMIC_ACTION);
                    intent.addFlags(FLAG_RECEIVER_FOREGROUND);
                    sendOrderedBroadcast(intent, DYNAMIC_PERMISSION);
                    break;
                case R.id.dynamic_order_bg:
                    intent = new Intent(DYNAMIC_ACTION);
                    sendOrderedBroadcast(intent, DYNAMIC_PERMISSION);
                    break;
                case R.id.dynamic_para_bf:
                    intent = new Intent(DYNAMIC_ACTION);
                    intent.addFlags(FLAG_RECEIVER_FOREGROUND);
                    sendBroadcast(intent);
                    break;
                case R.id.dynamic_para_bg:
                    intent = new Intent(DYNAMIC_ACTION);
                    sendBroadcast(intent);
                    break;
                case R.id.static_order_bf:
                    intent = new Intent(TestBroadcastActivity.this, StaticReceiver.class);
                    intent.addFlags(FLAG_RECEIVER_FOREGROUND);
                    sendBroadcast(intent);
                    break;
                case R.id.static_order_bg:
                    intent = new Intent(TestBroadcastActivity.this, StaticReceiver.class);
                    sendBroadcast(intent);
                    break;
                case R.id.dynamic_order_bg_timeout:
                    intent = new Intent(DYNAMIC_ACTION_TIMEOUT);
                    intent.addFlags(FLAG_RECEIVER_FOREGROUND);
                    sendOrderedBroadcast(intent, DYNAMIC_PERMISSION);
                    break;
            }
        }
    };
}
