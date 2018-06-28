package com.ll.anr.anr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.content.Intent.FLAG_RECEIVER_FOREGROUND;

public class TestServiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("com.anr.ll");
                intent.addFlags(FLAG_RECEIVER_FOREGROUND);
                sendBroadcast(intent);
            }
        });


//        findViewById(R.id.world).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MyService.class);
//                bindService(intent, new ServiceConnection() {
//                    @Override
//                    public void onServiceConnected(ComponentName name, IBinder service) {
//                        Log.e("Ruby","onServiceConnected");
//                    }
//
//                    @Override
//                    public void onServiceDisconnected(ComponentName name) {
//
//                    }
//
//                }, BIND_AUTO_CREATE);
//            }
//        });
    }


}
