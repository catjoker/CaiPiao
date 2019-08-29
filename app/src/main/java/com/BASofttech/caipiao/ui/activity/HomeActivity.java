package com.BASofttech.caipiao.ui.activity;

import android.Manifest;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.ui.fragment.Fragment_Gift;
import com.BASofttech.caipiao.ui.fragment.Fragment_Home;
import com.BASofttech.caipiao.ui.fragment.Fragment_LuckyPan;
import com.BASofttech.caipiao.ui.fragment.Fragment_Me;
import com.BASofttech.caipiao.ui.fragment.Fragment_Random;
import com.BASofttech.caipiao.util.Constant;
import com.BASofttech.caipiao.util.LogUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.yanzhenjie.permission.AndPermission;

import butterknife.BindView;
import butterknife.OnClick;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class HomeActivity extends BaseActivity{
	@BindView(R.id.rb_num0)
	AppCompatRadioButton rb_num0;
	@BindView(R.id.rb_num1)
	AppCompatRadioButton rb_num1;
	@BindView(R.id.rb_num2)
	AppCompatRadioButton rb_num2;
	@BindView(R.id.rb_num3)
	AppCompatRadioButton rb_num3;
	@BindView(R.id.rb_num4)
	AppCompatRadioButton rb_num4;
	@BindView(R.id.fl_main)
	FrameLayout fl_main;
	private Fragment_Home first;
	private Fragment_Gift second;
	private Fragment_LuckyPan third;
	private Fragment_Random forth;
	private Fragment_Me fifth;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private long exitTime;
	//	private ViewPager mViewPager;

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }
    @Override
    protected void initView() {
		
		first = new Fragment_Home();
		second = new Fragment_Gift();
		third = new Fragment_LuckyPan();
		forth = new Fragment_Random();
		fifth = new Fragment_Me();
		AndPermission.with(this)
				.runtime()
				.permission(Manifest.permission.READ_PHONE_STATE,ACCESS_FINE_LOCATION,ACCESS_COARSE_LOCATION)
				.onGranted(permissions -> {
					// Storage permission are allowed.
				})
				.onDenied(permissions -> {
					// Storage permission are not allowed.
				})
				.start();
	}
    @Override
    protected void initData() {
		rb_num1.setText("开奖信息");
		rb_num0.setText("首页");
		rb_num3.setText("随机大厅");
		rb_num2.setText("大转盘");
		changeFragment(first);
		SlidingMenu slidingMenu = new SlidingMenu(this);

		slidingMenu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
//		slidingMenu.setShadowDrawable(R.drawable.shadow);
  
        // 设置滑动菜单视图的宽度  (距离右侧边框最多相差多少距离)
//		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		slidingMenu.setBehindWidthRes(R.dimen.slidingmenu_offset);    //滑动后菜单显示宽度
		// 设置渐入渐出效果的值
		slidingMenu.setFadeDegree(0.35f);
        /** 
         * SLIDING_WINDOW will include the Title/ActionBar in the content 
         * section of the SlidingMenu, while SLIDING_CONTENT does not. 
         */
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
//		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
		slidingMenu.setMenu(R.layout.left_menu);
		showToast("呵呵复呵呵");
//		mViewPager = (ViewPager) findViewById(R.id.viewpager);


	}
     public void showPopwindow(){
		 View  contentView = LayoutInflater.from(context).inflate(R.layout.pop_window,null,false);
		 PopupWindow pw = new PopupWindow(contentView, 400,350);
		 pw.setTouchable(true);
		 pw.setTouchInterceptor(new View.OnTouchListener() {
			 @Override
			 public boolean onTouch(View v, MotionEvent event) {
				 Log.e("touch","touch");
				 return true;
			 }
		 });
		 pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		 pw.setOutsideTouchable(true);
		 View view = LayoutInflater.from(context).inflate(R.layout.activity_home,null);
		 pw.showAtLocation(view,Gravity.CENTER|Gravity.CENTER_HORIZONTAL,0,0);
//		 pw.showAsDropDown(view, -250,-250,Gravity.BOTTOM);
		 showToast("点击");
	 }
	/**
	 * 点击相应的按钮进入相应的fragment
	 * */
	@OnClick({R.id.rb_num0,R.id.rb_num1,R.id.rb_num2,R.id.rb_num3,R.id.rb_num4})
	public void onClick(View v) {
		switch (v.getId()) {
		//点击第一个按钮进入首页fragment
		case R.id.rb_num0:
//			showPopwindow();
			changeFragment(first);
			break;
			//点击第二个按钮进入活动fragment
		case R.id.rb_num1:
			changeFragment(second);
			break;
		case R.id.rb_num2:
		//	showMoreDialog();
			changeFragment(third);
			break;
		case R.id.rb_num3:
			changeFragment(forth);
			break;
		case R.id.rb_num4:
			changeFragment(fifth);
			break;
		default:
			break;
		}
	}

//	private void showMoreDialog() {
//		More_Dialog dialog =  new More_Dialog(this);
//		dialog.show();
//	}


	@Override
	protected void onResume() {
		super.onResume();
	}

	private void changeFragment(Fragment frag) {
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.replace(R.id.fl_main, frag);
		ft.commit();
	}

	@Override
	protected void onDestroy() {
		Constant.spinnerSb = null;
		super.onDestroy();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		LogUtil.e("keyDown","Keydown");
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exit();
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}
	public void exit() {
		if ((System.currentTimeMillis() - exitTime) > 2000) {
			showToast(getResources().getString(R.string.exit));
			exitTime = System.currentTimeMillis();
		} else {
			finish();
			System.exit(0);
		}

	}
}
