package com.ll.anr.anr;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class TestProviderActivity extends AppCompatActivity {

    ContentResolver resolver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_provider);
        findViewById(R.id.process_no_timeout).setOnClickListener(mClickListener);
        findViewById(R.id.process_timeout).setOnClickListener(mClickListener);
        resolver = getContentResolver();
    }


    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = null;
            switch (v.getId()) {
                case R.id.process_no_timeout:
                    uri = Uri.parse("content://com.ll.anr.anr.provider.main");
                    break;
                case R.id.process_timeout:
                    uri = Uri.parse("content://com.ll.anr.anr.provider.background");
                    break;
            }
            resolver.query(uri, null, null, null, "userid desc");

            Log.e("Ruby", "Timeout");
        }
    };


}
