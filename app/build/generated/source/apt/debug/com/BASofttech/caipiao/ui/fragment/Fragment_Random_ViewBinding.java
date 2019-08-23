// Generated code from Butter Knife. Do not modify!
package com.BASofttech.caipiao.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.BASofttech.caipiao.R;
import com.ajguan.library.EasyRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Fragment_Random_ViewBinding implements Unbinder {
  private Fragment_Random target;

  private View view7f09003c;

  private View view7f09003b;

  private View view7f09008c;

  @UiThread
  public Fragment_Random_ViewBinding(final Fragment_Random target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.bt_random, "field 'bt_random' and method 'onClick'");
    target.bt_random = Utils.castView(view, R.id.bt_random, "field 'bt_random'", Button.class);
    view7f09003c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.bt_clear, "field 'bt_clear' and method 'onClick'");
    target.bt_clear = Utils.castView(view, R.id.bt_clear, "field 'bt_clear'", Button.class);
    view7f09003b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_login, "field 'iv_login' and method 'onClick'");
    target.iv_login = Utils.castView(view, R.id.iv_login, "field 'iv_login'", ImageView.class);
    view7f09008c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tv = Utils.findRequiredViewAsType(source, R.id.tv, "field 'tv'", TextView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.lv, "field 'recyclerView'", RecyclerView.class);
    target.et = Utils.findRequiredViewAsType(source, R.id.et, "field 'et'", EditText.class);
    target.spinner = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinner'", AppCompatSpinner.class);
    target.easyRefreshLayout = Utils.findRequiredViewAsType(source, R.id.easyRefreshLayout, "field 'easyRefreshLayout'", EasyRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Fragment_Random target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.bt_random = null;
    target.bt_clear = null;
    target.iv_login = null;
    target.tv = null;
    target.recyclerView = null;
    target.et = null;
    target.spinner = null;
    target.easyRefreshLayout = null;

    view7f09003c.setOnClickListener(null);
    view7f09003c = null;
    view7f09003b.setOnClickListener(null);
    view7f09003b = null;
    view7f09008c.setOnClickListener(null);
    view7f09008c = null;
  }
}
