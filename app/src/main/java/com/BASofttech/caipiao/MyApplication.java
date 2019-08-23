package com.BASofttech.caipiao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import org.litepal.LitePal;

/**
 * created by stray cat on 2019/6/19.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
        SQLiteDatabase db = LitePal.getDatabase();
    }
}
