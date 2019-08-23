// Generated code from Butter Knife. Do not modify!
package com.BASofttech.caipiao.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.BASofttech.caipiao.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Fragment_Me_ViewBinding implements Unbinder {
  private Fragment_Me target;

  private View view7f0900d6;

  private View view7f0900d2;

  private View view7f0900d3;

  private View view7f0900d4;

  private View view7f0900d5;

  @UiThread
  public Fragment_Me_ViewBinding(final Fragment_Me target, View source) {
    this.target = target;

    View view;
    target.tv_caipiaoid = Utils.findRequiredViewAsType(source, R.id.tv_caipiaoid, "field 'tv_caipiaoid'", AppCompatTextView.class);
    view = Utils.findRequiredView(source, R.id.rl_state, "field 'rl_state' and method 'onClick'");
    target.rl_state = Utils.castView(view, R.id.rl_state, "field 'rl_state'", RelativeLayout.class);
    view7f0900d6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_background, "field 'rl_background' and method 'onClick'");
    target.rl_background = Utils.castView(view, R.id.rl_background, "field 'rl_background'", RelativeLayout.class);
    view7f0900d2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_background1, "field 'rl_background1' and method 'onClick'");
    target.rl_background1 = Utils.castView(view, R.id.rl_background1, "field 'rl_background1'", RelativeLayout.class);
    view7f0900d3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_background2, "field 'rl_background2' and method 'onClick'");
    target.rl_background2 = Utils.castView(view, R.id.rl_background2, "field 'rl_background2'", RelativeLayout.class);
    view7f0900d4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_background3, "field 'rl_background3' and method 'onClick'");
    target.rl_background3 = Utils.castView(view, R.id.rl_background3, "field 'rl_background3'", RelativeLayout.class);
    view7f0900d5 = view;
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
    Fragment_Me target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_caipiaoid = null;
    target.rl_state = null;
    target.rl_background = null;
    target.rl_background1 = null;
    target.rl_background2 = null;
    target.rl_background3 = null;

    view7f0900d6.setOnClickListener(null);
    view7f0900d6 = null;
    view7f0900d2.setOnClickListener(null);
    view7f0900d2 = null;
    view7f0900d3.setOnClickListener(null);
    view7f0900d3 = null;
    view7f0900d4.setOnClickListener(null);
    view7f0900d4 = null;
    view7f0900d5.setOnClickListener(null);
    view7f0900d5 = null;
  }
}
