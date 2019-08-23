package com.BASofttech.caipiao.ui.activity;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.util.DragFloatActionButton;
import com.BASofttech.caipiao.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.login_bt)
    AppCompatButton login_bt;
    @BindView(R.id.login_et_password)
    AppCompatEditText login_et_password;
    @BindView(R.id.login_et_user)
    AppCompatEditText login_et_user;
    @BindView(R.id.mr)
    DragFloatActionButton iv_drag;
    private String psw;
    private String id;

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

    @OnClick({R.id.mr, R.id.login_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mr:
                //                if(!iv_drag.isDrag()){
                showToast("响应点击");
                //                }
                finish();
                break;
            case R.id.login_bt:
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
}
