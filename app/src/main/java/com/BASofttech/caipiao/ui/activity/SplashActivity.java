package com.BASofttech.caipiao.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;

import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.ui.activity.HomeActivity;
import com.BASofttech.caipiao.util.ToastUtil;

public class SplashActivity extends Activity {
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
    private Button sp_jump_btn;
    private View view;
    private boolean isOnclick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this, R.layout.activity_splash, null);
        ImageView sp_iv = (ImageView) view.findViewById(R.id.sp_iv);
//        GlideApp.with(this)
//                .load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//是否使用缓存默认使用   此处设置不使用
//                .error(R.drawable.catmobile)
//                .into(sp_iv);
//        sp_jump_btn = (Button) view.findViewById(R.id.
// sp_jump_btn);
        // TODO Auto-generated method stub
        setContentView(view);
//        countDownTimer.start();
        /*sp_jump_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity();
                finish();
            }
        });*/

        final AlphaAnimation aa = new AlphaAnimation(0.1f, 1.5f);
        aa.setDuration(3000);
        view.startAnimation(aa);
        sp_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOnclick = true;
                finish();
                toActivity();
            }
        });
        aa.setAnimationListener(new AnimationListener() {

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
                    Log.e("end", "onanimationend");
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
        /*if (countDownTimer != null) {
            countDownTimer.cancel();
        }*/
    }
}
