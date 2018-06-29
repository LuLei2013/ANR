package android.content;

import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ContentProviderClient {

    public void setDetectNotResponding(long timeoutMillis) {
    }

    public @Nullable
    Cursor query(@NonNull Uri url, @Nullable String[] projection,
                 @Nullable String selection, @Nullable String[] selectionArgs,
                 @Nullable String sortOrder) throws RemoteException {
        return null;
    }
}
