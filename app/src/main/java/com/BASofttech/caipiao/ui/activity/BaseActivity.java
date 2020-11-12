package com.BASofttech.caipiao.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.BASofttech.caipiao.util.LogUtil;
import com.BASofttech.caipiao.util.ToastUtil;

import butterknife.ButterKnife;

/**
 * created by stray cat on 2019/8/22.
 */
public abstract class BaseActivity extends AppCompatActivity {
    Context context;
    private boolean isshowtitle = true;
    private boolean isshowstate = true;
    private long exitTime = 0;
    private final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        if(!isshowtitle){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if(isshowstate){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                // 透明状态栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                // 设置状态栏字体颜色
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
                getWindow().addFlags(WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION);
            }
        }
        setContentView(initLayout());
        ButterKnife.bind(this);
        initView();
        initData();
    }
    /**
     * 加载布局
     * */
    protected abstract int initLayout();
    /**
     * 初始化布局控件
     * */
    protected abstract void initView();
    /**
     * 初始化数据
     * */
    protected abstract void initData();
    /**
     * Log展示(个人习惯使用error级别)
     * */
    protected void showLog(String msg){
        LogUtil.e(TAG,msg);
    }
    /**
     * Toast展示
     * */
    protected void showToast(String msg){
        ToastUtil.showToast(context,msg);
    }
    /**
     * 设置显示标题栏
     * */
    protected void setTitle(boolean isshow){
        isshowtitle = isshow;
    }
    /**
     * 设置显示状态栏
     * */
    protected void setState(boolean isshow){
        isshowstate = isshow;
    }
    /**
     * 跳转新页面
     * */
    protected void toNewActivity(Context context, Class<? extends Activity> clazz) {
        toNewActivity(context, clazz, null);
    }

    protected void toNewActivity(Context context, Class<? extends Activity> clazz, Bundle bundle) {
        toNewActivity(context, clazz, null, 0);
    }

    protected void toNewActivity(Context context, Class<? extends Activity> clazz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(context, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (requestCode == 0) {
            startActivityForResult(intent,requestCode);
        } else {
            startActivity(intent);
        }
    }
    /**
     * 退出APP
     * */
    protected void exit(){
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            showToast("再点一次你就要退出了哦");
            exitTime = System.currentTimeMillis();
        } else {
//			finish();
//			System.exit(0);
            /**
             * 不退出应用,到后台
             * */
            moveTaskToBack(true);
        }
    }
}
