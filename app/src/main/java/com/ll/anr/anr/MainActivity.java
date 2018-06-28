package com.ll.anr.anr;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    private final static String[] TARGET_ACTIVITIES = {
            TestServiceActivity.class.getSimpleName(),
            TestBroadcastActivity.class.getSimpleName(),
            TestProviderActivity.class.getSimpleName(),
            TestInputEventActivity.class.getSimpleName()
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, TARGET_ACTIVITIES);
        setListAdapter(arrayAdapter);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent();
        intent.setClassName(this, this.getPackageName() + "." + TARGET_ACTIVITIES[position]);
        startActivity(intent);
    }
}