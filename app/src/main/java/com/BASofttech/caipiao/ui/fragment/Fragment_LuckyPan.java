package com.BASofttech.caipiao.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.util.LuckPanLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by BASOFT on 2018/9/29.
 */

public class Fragment_LuckyPan extends BaseFragment implements LuckPanLayout.AnimationEndListener {
    String[] strs;
    @BindView(R.id.luckpan_layout)
    LuckPanLayout luckPanLayout;
    @BindView(R.id.go)
    ImageView goBtn;
    @BindView(R.id.tv_text)
    TextView tv_text;
    @BindView(R.id.hit_user_tv)
    TextView hit_user_tv;
    @BindView(R.id.huodong_rule)
    TextView huodong_rule;

    @Override
    protected int setLayout() {
        return R.layout.fragment_luckypan;
    }

    @Override
    protected void initView(View view) {
        strs = getResources().getStringArray(R.array.names);
        luckPanLayout.setAnimationEndListener(this);
    }

    @Override
    protected void initData() {
        tv_text.setText("幸运大转盘");
        //        hit_user_tv.setText("服务器的数据");
        // huodong_rule.setText("服务器的数据");
    }

    /*public void rotation(View view){
        luckPanLayout.rotate(-1,100);
    }*/
    @Override
    public void endAnimation(int position) {
        //转盘结束获得转盘的结果
        Toast.makeText(getActivity(), "Position = " + position + "," + strs[position], Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.go})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go:
                luckPanLayout.rotate(1, 100);
                break;
        }
    }
}
