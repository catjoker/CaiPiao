package com.BASofttech.caipiao.util;

import java.lang.ref.WeakReference;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	private static WeakReference<Toast> prevToast = new WeakReference<Toast>(null);
	private static WeakReference<Context> prevContext = new WeakReference<Context>(null);
	/**
	 * 弹出Toast消息
	 * 
	 * @param msg
	 */
	//正常简化弹出消息
	public static void showToast(Context cont, String msg) {
		showToast(cont, msg, Toast.LENGTH_SHORT);
	}
	//如果string的xml有写好的文字,可以直接引用
	public static void showToast(Context cont, int msg) {
		showToast(cont, cont.getString(msg), Toast.LENGTH_SHORT);
	}

	private static void showToast(Context cont, int msg, int time) {
		showToast(cont, cont.getString(msg), time);
	}

	private static void showToast(Context cont, String msg, int time) {
		if (prevContext.get() != null && prevToast.get() != null && prevContext.get() == cont) {
			Toast toast = prevToast.get();
			toast.setText(msg);
			toast.setDuration(time);
			toast.show();
			return;
		}
		Toast toast = Toast.makeText(cont, msg, time);
		toast.show();
		prevContext = new WeakReference<Context>(cont);
		prevToast = new WeakReference<Toast>(toast);
	}
}
