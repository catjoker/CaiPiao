package com.BASofttech.caipiao.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.util.LogUtil;
import com.BASofttech.caipiao.util.ToastUtil;

public class SplashActivity2 extends Activity {
    /* CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
         @Override
         public void onTick(long millisUntilFinished) {
             sp_jump_btn.setText("跳过广告" + millisUntilFinished / 1000 + "s");
         }

         @Override
         public void onFinish() {
             sp_jump_btn.setText("跳过广告"+0+"s");
             toActivity();
         }
     };*/
    private AppCompatButton sp_jump_btn;
    private View view;
    private boolean isOnclick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this, R.layout.activity_splash, null);
        AppCompatImageView sp_iv = (AppCompatImageView) view.findViewById(R.id.sp_iv);
        timerStart();
        sp_jump_btn = (AppCompatButton)view.findViewById(R.id.sp_jump_btn);
        // TODO Auto-generated method stub
        setContentView(view);

        final AlphaAnimation aa = new AlphaAnimation(0.1f, 1.5f);
        aa.setDuration(3000);
        view.startAnimation(aa);
        sp_jump_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOnclick = true;
                LogUtil.e("count","count");
                sp_jump_btn.setClickable(false);
                toActivity();
            }
        });

        aa.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                if (isOnclick) {
                    ToastUtil.showToast(getApplication(),"jieshu");
                    isOnclick = false;
                } else {
                    toActivity();
                    finish();
                }

            }

        });
    }

    private void toActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        view.clearAnimation();
    }
    /**
     * 倒数计时器
     */
    private CountDownTimer timer = new CountDownTimer( 3000, 1000) {
        /**
         * 固定间隔被调用,就是每隔countDownInterval会回调一次方法onTick
         * @param millisUntilFinished
         */
        @Override
        public void onTick(long millisUntilFinished) {
            sp_jump_btn.setText("跳过"+formatTime(millisUntilFinished)+"秒");
        }

        /**
         * 倒计时完成时被调用
         */
        @Override
        public void onFinish() {
            sp_jump_btn.setText("跳过0秒");
        }
    };

    /**
     * 将毫秒转化为 分钟：秒 的格式
     *
     * @param millisecond 毫秒
     * @return
     */
    public String formatTime(long millisecond) {
        int minute;//分钟
        int second;//秒数
        minute = (int) ((millisecond / 1000) / 60);
        second = (int) ((millisecond / 1000) % 60);
        if (minute < 10) {
            if (second < 10) {
//                return "0" + minute + ":" + "0" + second;
            return   ""+second;
            } else {
//                return "0" + minute + ":" + second;
                return second+"";
            }
        }else {
            if (second < 10) {
//                return minute + ":" + "0" + second;
                return  "" + second;
            } else {
//                return minute + ":" + second;
                return "" + second;
            }
        }
    }

    /**
     * 取消倒计时
     */
    public void timerCancel() {
        timer.cancel();
    }

    /**
     * 开始倒计时
     */
    public void timerStart() {
        timer.start();
    }
}
