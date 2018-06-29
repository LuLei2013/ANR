package com.ll.anr.anr;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Method;


public class TestProviderActivity extends AppCompatActivity {
    final private static long PROVIDER_ANR_TIMEOUT = 10 * 1000;
    ContentProviderClient mMainClient;
    ContentProviderClient mBackgroundClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_provider);
        findViewById(R.id.process_no_timeout).setOnClickListener(mClickListener);
        findViewById(R.id.process_timeout).setOnClickListener(mClickListener);


    }


    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri;
            try {
                switch (v.getId()) {

                    case R.id.process_no_timeout:
                        uri = Uri.parse("content://com.ll.anr.anr.provider.main");
                        if (mMainClient == null)
                            mMainClient = getContentProviderTimeOut("com.ll.anr.anr.provider.main");
                        mMainClient.query(uri, null, null, null, "userid desc");
                        break;
                    case R.id.process_timeout:
                        uri = Uri.parse("content://com.ll.anr.anr.provider.background");
                        if (mBackgroundClient == null)
                            mBackgroundClient = getContentProviderTimeOut("com.ll.anr.anr.provider.background");
                        mBackgroundClient.query(uri, null, null, null, "userid desc");
                        break;
                }

            } catch (RemoteException e) {
                Log.e("Ruby", "query timeout");
            }


            Log.e("Ruby", "Timeout");
        }
    };


    private ContentProviderClient getContentProviderTimeOut(String authority) {
        ContentResolver resolver = getContentResolver();
        final ContentProviderClient client = resolver.acquireUnstableContentProviderClient(
                authority);
        if (client == null) {
            Log.e("Ruby", "TestProviderActivity");
        }

        try {
            Method method = client.getClass().getMethod("setDetectNotResponding", long.class);
            method.invoke(client, PROVIDER_ANR_TIMEOUT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return client;
    }

}
