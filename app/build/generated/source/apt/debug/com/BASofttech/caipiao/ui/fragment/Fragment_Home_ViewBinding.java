// Generated code from Butter Knife. Do not modify!
package com.BASofttech.caipiao.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cn.jzvd.JZVideoPlayerStandard;
import com.BASofttech.caipiao.R;
import com.youth.banner.Banner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Fragment_Home_ViewBinding implements Unbinder {
  private Fragment_Home target;

  private View view7f09010c;

  @UiThread
  public Fragment_Home_ViewBinding(final Fragment_Home target, View source) {
    this.target = target;

    View view;
    target.banner = Utils.findRequiredViewAsType(source, R.id.banner, "field 'banner'", Banner.class);
    target.jzVideoPlayerStandard = Utils.findRequiredViewAsType(source, R.id.videoplayer, "field 'jzVideoPlayerStandard'", JZVideoPlayerStandard.class);
    view = Utils.findRequiredView(source, R.id.test_bt_notice, "field 'test_bt_notice' and method 'onClick'");
    target.test_bt_notice = Utils.castView(view, R.id.test_bt_notice, "field 'test_bt_notice'", Button.class);
    view7f09010c = view;
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
    Fragment_Home target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.banner = null;
    target.jzVideoPlayerStandard = null;
    target.test_bt_notice = null;

    view7f09010c.setOnClickListener(null);
    view7f09010c = null;
  }
}
