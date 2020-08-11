package com.BASofttech.caipiao.util;

import android.Manifest;
import android.content.Context;

import com.yanzhenjie.permission.AndPermission;

/**
 * created by stray cat on 2019/9/2.
 */
public class PermissionUtil {
    public static void setPermission(String[] permission, Context context){
        AndPermission.with(context)
                .runtime()
                .permission(permission)
                .onGranted(permissions -> {

                })
                .onDenied(permissions -> {
                    if(permissions.toString().contains(Manifest.permission.READ_PHONE_STATE)){
                        ToastUtil.showToast(context,"请设置界面设置读取电话权限");
                    }else if(permissions.toString().contains(Manifest.permission.ACCESS_FINE_LOCATION)){
                        ToastUtil.showToast(context,"请设置界面设置定位权限");
                    }
                })
                .start();
    }
}
