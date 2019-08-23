// Generated code from Butter Knife. Do not modify!
package com.BASofttech.caipiao.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.util.DragFloatActionButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view7f0900a3;

  private View view7f0900b1;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.login_bt, "field 'login_bt' and method 'onClick'");
    target.login_bt = Utils.castView(view, R.id.login_bt, "field 'login_bt'", AppCompatButton.class);
    view7f0900a3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.login_et_password = Utils.findRequiredViewAsType(source, R.id.login_et_password, "field 'login_et_password'", AppCompatEditText.class);
    target.login_et_user = Utils.findRequiredViewAsType(source, R.id.login_et_user, "field 'login_et_user'", AppCompatEditText.class);
    view = Utils.findRequiredView(source, R.id.mr, "field 'iv_drag' and method 'onClick'");
    target.iv_drag = Utils.castView(view, R.id.mr, "field 'iv_drag'", DragFloatActionButton.class);
    view7f0900b1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.login_bt = null;
    target.login_et_password = null;
    target.login_et_user = null;
    target.iv_drag = null;

    view7f0900a3.setOnClickListener(null);
    view7f0900a3 = null;
    view7f0900b1.setOnClickListener(null);
    view7f0900b1 = null;
  }
}
