// Generated code from Butter Knife. Do not modify!
package com.BASofttech.caipiao.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.BASofttech.caipiao.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  private View view7f0900c6;

  private View view7f0900c7;

  private View view7f0900c8;

  private View view7f0900c9;

  private View view7f0900ca;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(final HomeActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.rb_num0, "field 'rb_num0' and method 'onClick'");
    target.rb_num0 = Utils.castView(view, R.id.rb_num0, "field 'rb_num0'", AppCompatRadioButton.class);
    view7f0900c6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_num1, "field 'rb_num1' and method 'onClick'");
    target.rb_num1 = Utils.castView(view, R.id.rb_num1, "field 'rb_num1'", AppCompatRadioButton.class);
    view7f0900c7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_num2, "field 'rb_num2' and method 'onClick'");
    target.rb_num2 = Utils.castView(view, R.id.rb_num2, "field 'rb_num2'", AppCompatRadioButton.class);
    view7f0900c8 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_num3, "field 'rb_num3' and method 'onClick'");
    target.rb_num3 = Utils.castView(view, R.id.rb_num3, "field 'rb_num3'", AppCompatRadioButton.class);
    view7f0900c9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_num4, "field 'rb_num4' and method 'onClick'");
    target.rb_num4 = Utils.castView(view, R.id.rb_num4, "field 'rb_num4'", AppCompatRadioButton.class);
    view7f0900ca = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.fl_main = Utils.findRequiredViewAsType(source, R.id.fl_main, "field 'fl_main'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rb_num0 = null;
    target.rb_num1 = null;
    target.rb_num2 = null;
    target.rb_num3 = null;
    target.rb_num4 = null;
    target.fl_main = null;

    view7f0900c6.setOnClickListener(null);
    view7f0900c6 = null;
    view7f0900c7.setOnClickListener(null);
    view7f0900c7 = null;
    view7f0900c8.setOnClickListener(null);
    view7f0900c8 = null;
    view7f0900c9.setOnClickListener(null);
    view7f0900c9 = null;
    view7f0900ca.setOnClickListener(null);
    view7f0900ca = null;
  }
}
