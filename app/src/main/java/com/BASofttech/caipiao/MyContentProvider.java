package com.BASofttech.caipiao;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.BASofttech.caipiao.util.LogUtil;

/**
 * created by stray cat on 2019/6/17.
 */
public class MyContentProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        LogUtil.e("provider","create");
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        LogUtil.e("provider","query");
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        LogUtil.e("provider","type");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        LogUtil.e("provider","insert");
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        LogUtil.e("provider","delete");
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        LogUtil.e("provider","update");
        return 0;
    }
}
