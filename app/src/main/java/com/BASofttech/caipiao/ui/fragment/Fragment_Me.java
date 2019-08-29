package com.BASofttech.caipiao.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.AppCompatTextView;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.util.GetMacUtil;
import com.BASofttech.caipiao.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class Fragment_Me extends BaseFragment {
    @BindView(R.id.tv_caipiaoid)
    AppCompatTextView tv_caipiaoid;
    @BindView(R.id.rl_state)
    RelativeLayout rl_state;
    @BindView(R.id.rl_background)
    RelativeLayout rl_background;
    @BindView(R.id.rl_background1)
    RelativeLayout rl_background1;
    @BindView(R.id.rl_background2)
    RelativeLayout rl_background2;
    @BindView(R.id.rl_background3)
    RelativeLayout rl_background3;

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView(View view) {
    }

    @Override
    protected void initData() {
        String macString = GetMacUtil.getMac(getActivity());
       /*StringBuilder sb = new StringBuilder();
       for(String str : macString.split(":")){
           sb.append(str);
       }*/
        tv_caipiaoid.setText(macString.toUpperCase());
    }


    @OnClick({R.id.rl_state, R.id.rl_background, R.id.rl_background1, R.id.rl_background2, R.id.rl_background3})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_state:
                showToast("跳转个人详情页面");
                break;
            case R.id.rl_background:
                showToast("跳转充值页面");
                break;
            case R.id.rl_background1:
                showToast("跳转彩票大厅");
                break;
            case R.id.rl_background2:
                showToast("中奖用户名单");
                break;
            case R.id.rl_background3:
                View view = View.inflate(getActivity(), R.layout.dialog_logout, null);
                AppCompatTextView tv_title = view.findViewById(R.id.tv_title);
                tv_title.setText("您确定要退出登录么");
                //加上style  和contextThemeWrapper 可以将黑边去除  确定取消按钮需要自定义button   并且不能使用positiveButton和negativeButon
                new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.Theme_Transparent))
//                        .setTitle("提示")
//                        .setMessage("您确定要退出登录么")
                        .setView(view)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               showToast("退出成功");
                            }
                        }).setNegativeButton("取消", null)
                        .show();
                break;
            default:
                break;
        }
    }
}
