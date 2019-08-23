package com.BASofttech.caipiao.sql;


import com.BASofttech.caipiao.util.DBInstance;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 16/12/22 这个也暂时没什么用
 */
public class DBHelper {

    private final String CLASSTAG = DBHelper.class.getSimpleName();
    Context mCotext;
    private final static String _DB_NAME = "SSQ";
    private final static int _DB_VERSION = 1;

    OpenHelper mDbOpenHelper;

    public DBHelper(Context context) {
        super();
        mCotext = context;
        mDbOpenHelper = new OpenHelper(context);
    }

    private SQLiteDatabase openDatabase(boolean writable) {

        SQLiteDatabase db = null;

        if (mDbOpenHelper != null) {
            mDbOpenHelper.close();
        }

        try {
            if (writable) {
                // 获取一个用于操作数据库的SQLiteDatabase实例
                // 以读写方式打开数据库，一旦数据库的磁盘空间满了，数据库就只能读而不能写，倘若使用的是getWritableDatabase()
                // 方法就会出错
                db = mDbOpenHelper.getWritableDatabase();
            } else {
                // 获取一个用于操作数据库的SQLiteDatabase实例
                // 先以读写方式打开数据库，如果数据库的磁盘空间满了，就会打开失败，当打开失败后会继续尝试以只读方式打开数据库。如果该问
                // 题成功解决，则只读数据库对象就会关闭，然后返回一个可读写的数据库对象。
                db = mDbOpenHelper.getReadableDatabase();
            }
        } catch (SQLiteFullException e) {

        } catch (SQLiteDiskIOException e) {

        } catch (SQLiteException e) {

        }
        return db;
    }

    final static String BALLNUMBER = "BALLNUMBER";

    final static String CREAT_BALLNUMBER = "CREATE TABLE BALLNUMBER" +
            "(" +
            "id TEXT VARCHAR(20)" +
            "BALLNUMBERS TEXT VARCHAR(20)" +
            ")";

    public int insertBallNumber(String str, String id) {
        int errorCode = 0;
        synchronized (DBInstance.getInstance()) {
            SQLiteDatabase mDb = openDatabase(true);
            if (mDb != null) {
                /** 开始事务 */
                mDb.beginTransaction();
                try {
                    ContentValues insertValues = new ContentValues();
                    insertValues.put("BALLNUMBERS", str);
                    insertValues.put("id", id);
                    // updateProductList(mDb, PRODUCT_LIST_EXCEL);
                    // 设置事务处理成功，不设置会自动回滚不提交。
                    // 在setTransactionSuccessful和endTransaction之间不进行任何数据库操作
                    long i = mDb.insertOrThrow(BALLNUMBER, null, insertValues);
                    mDb.setTransactionSuccessful();

                } catch (SQLException e) {
                    errorCode--;

                } finally {
                    mDb.endTransaction();
                    mDb.close();
                    //returnExcelCount(ORDER_MANAGEMENT_EXCEL, null);
                }
            } else {
                errorCode--;
            }
        }
        return errorCode;
    }

    private class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context) {
            super(context, _DB_NAME, null, _DB_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            /** 开始事务 */
            db.beginTransaction();

            try {
                // 建表
                db.execSQL(CREAT_BALLNUMBER);// 产品列表
                db.setTransactionSuccessful();

            } catch (Exception ex) {

                ex.printStackTrace();

            } finally {

                if (db != null) {

                    db.endTransaction();
                }
            }
        }

        //更新数据库
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

        }
    }
}
