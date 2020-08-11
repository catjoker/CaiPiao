package com.BASofttech.caipiao.ui.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.R2;
import com.BASofttech.caipiao.util.DragFloatActionButton;
import com.BASofttech.caipiao.util.LogUtil;
import com.BASofttech.caipiao.util.ToastUtil;
import com.yanzhenjie.permission.AndPermission;

import butterknife.BindView;
import butterknife.OnClick;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class LoginActivity extends BaseActivity {
    @BindView(R2.id.login_bt)
    AppCompatButton login_bt;
    @BindView(R2.id.login_et_password)
    AppCompatEditText login_et_password;
    @BindView(R2.id.login_et_user)
    AppCompatEditText login_et_user;
    @BindView(R2.id.mr)
    DragFloatActionButton iv_drag;
    private String psw;
    private String id;
    private CancellationSignal mCancellationSignal;
    private BiometricPrompt.AuthenticationCallback mAuthenticationCallback;
    private BiometricPrompt mBiometricPrompt;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //禁止截图
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R2.id.mr, R2.id.login_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mr:
                //                if(!iv_drag.isDrag()){
                showToast("响应点击");
                showLog(getResources().getString(R.string.exit));
                finish();
                break;
            case R.id.login_bt:
                finger();
                id = login_et_user.getText().toString();
                psw = login_et_password.getText().toString();
                if (id != null && id.length() > 0) {
                    if (psw == null || psw.length() <= 0) {
                        showToast("密码不能为空");
                    } else {
                        //TODO  需要验证用户名密码的逻辑
                        /**
                         * 使用litepal进行sqlite存储
                         * */
//                        LitePal.deleteAll(LoginModel.class,"name = ?" , "hehe2");
//                        LitePal.where().order("name").find(LoginModel.class);
//                        LoginModel lm = new LoginModel();
//                        lm.setName("hehe2");
//                        lm.setUserid("1001523");
//                        lm.setPassword("12454");
//                        lm.save();
//                        LoginModel lm2 = new LoginModel();
//                        lm2.setPassword("999999");
//                        lm2.update(1);
                        /**updateALL 第一个参数是where条件语句 必须是字段名 和问号  后面的参数写出相应的固定值
                         */
                        //lm2.updateAll("name = ?","hehe");
                        showToast("登陆成功");
                    }
                } else {
                    showToast("用户名不能为空");
                }
                break;
        }
    }

    //TODO 如果是推送到这个页面,则重新打开首页
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //安卓9.0指纹识别   不可自定义界面  只能有一个按钮(取消/使用密码)
    @TargetApi(Build.VERSION_CODES.P)
    public void finger(){
        mBiometricPrompt = new BiometricPrompt
                .Builder(LoginActivity.this)
                .setTitle("请使用指纹登录")
                .setDescription("呵呵呵呵呵")
                .setSubtitle("测试测试")
                .setNegativeButton("取消", LoginActivity.this.getMainExecutor(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToast("哈萨克哈老客户");
                    }
                })
                .build();

        mCancellationSignal = new CancellationSignal();
        mCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
            @Override
            public void onCancel() {
                //handle cancel result
                Log.e("login", "Canceled");
            }
        });

        mAuthenticationCallback = new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);

                LogUtil.e("login", "onAuthenticationError " + errString);
            }

            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                showToast("登陆成功");
                LogUtil.e("login", "onAuthenticationSucceeded " + result.toString());
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();

                LogUtil.e("login", "onAuthenticationFailed ");
            }

            @Override
            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                super.onAuthenticationHelp(helpCode, helpString);
                LogUtil.e("login", "onAuthenticationSucceeded " + helpString.toString());

            }
        };

        mBiometricPrompt.authenticate(mCancellationSignal, getMainExecutor(), mAuthenticationCallback);
    }
}
