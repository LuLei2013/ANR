package com.ll.anr.anr;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ll.anr.anr.service.MyService;


public class TestServiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_service);

        findViewById(R.id.start_service).setOnClickListener(mOnclickListener);
        findViewById(R.id.stop_service).setOnClickListener(mOnclickListener);
        findViewById(R.id.bind_service).setOnClickListener(mOnclickListener);
        findViewById(R.id.unbind_service).setOnClickListener(mOnclickListener);
    }


    private View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(TestServiceActivity.this, MyService.class);
            switch (v.getId()) {
                case R.id.start_service:
                    startService(intent);
                    break;
                case R.id.stop_service:
                    stopService(intent);
                    break;
                case R.id.bind_service:
                    bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                    break;
                case R.id.unbind_service:
                    unbindService(serviceConnection);
                    break;
            }
        }
    };

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("Ruby", "onServiceConnected start");
            sleep30();
            Log.e("Ruby", "onServiceConnected end");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void sleep30() {
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
