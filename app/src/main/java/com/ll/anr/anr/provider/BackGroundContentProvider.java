package com.ll.anr.anr.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.ll.anr.anr.Application.THREE_SECOND;


public class BackGroundContentProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        Log.e("Ruby", "BackGroundContentProvider  onCreate start");
        try {
            Thread.sleep(THREE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("Ruby", "BackGroundContentProvider  onCreate end");
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        Log.e("Ruby", "BackGroundContentProvider  query start");
        try {
            Thread.sleep(10 * THREE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("Ruby", "BackGroundContentProvider  query end");
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
