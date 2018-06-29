package com.ll.anr.anr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TestActivity extends AppCompatActivity {

    final static private int SECOND = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        Log.e("Ruby", "TestActivity onCreate start ");
//        sleep20();
        Log.e("Ruby", "TestActivity onCreate end ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Ruby", "TestActivity onResume start ");
//        sleep20();
        Log.e("Ruby", "TestActivity onResume end ");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Ruby", "TestActivity onPause start ");
        sleep20();
        Log.e("Ruby", "TestActivity onPause end ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Ruby", "TestActivity onDestroy start ");
        sleep20();
        Log.e("Ruby", "TestActivity onDestroy end ");
    }


    private void sleep20() {
        try {
            Thread.sleep(20 * SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
