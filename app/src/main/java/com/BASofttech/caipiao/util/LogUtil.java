package com.BASofttech.caipiao.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class LogUtil {
	//测试
    public static final boolean LOG = true;
    //上线
//    public static final boolean LOG = false;
     
//    public static void toast(Context context,String content) {
//        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
//    }
    
    public static void v(String tag,String msg) {
        if (LOG) {
            Log.v(tag, msg);
        }
    }
     
    public static void d(String tag,String msg) {
        if (LOG) {
            Log.d(tag, msg);
        }
    }
    
    public static void i(String tag,String msg) {
        if (LOG) {
            Log.i(tag, msg);
        }
    }
    
    public static void w(String tag,String msg) {
        if (LOG) {
            Log.w(tag, msg);
        }
    }
    
    public static void e(String tag,String msg) {
        if (LOG) {
            Log.e(tag, msg);
        }
    }    
}