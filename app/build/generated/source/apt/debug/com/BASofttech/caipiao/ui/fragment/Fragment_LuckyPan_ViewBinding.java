// Generated code from Butter Knife. Do not modify!
package com.BASofttech.caipiao.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.util.LuckPanLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Fragment_LuckyPan_ViewBinding implements Unbinder {
  private Fragment_LuckyPan target;

  private View view7f090075;

  @UiThread
  public Fragment_LuckyPan_ViewBinding(final Fragment_LuckyPan target, View source) {
    this.target = target;

    View view;
    target.luckPanLayout = Utils.findRequiredViewAsType(source, R.id.luckpan_layout, "field 'luckPanLayout'", LuckPanLayout.class);
    view = Utils.findRequiredView(source, R.id.go, "field 'goBtn' and method 'onClick'");
    target.goBtn = Utils.castView(view, R.id.go, "field 'goBtn'", ImageView.class);
    view7f090075 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tv_text = Utils.findRequiredViewAsType(source, R.id.tv_text, "field 'tv_text'", TextView.class);
    target.hit_user_tv = Utils.findRequiredViewAsType(source, R.id.hit_user_tv, "field 'hit_user_tv'", TextView.class);
    target.huodong_rule = Utils.findRequiredViewAsType(source, R.id.huodong_rule, "field 'huodong_rule'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Fragment_LuckyPan target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.luckPanLayout = null;
    target.goBtn = null;
    target.tv_text = null;
    target.hit_user_tv = null;
    target.huodong_rule = null;

    view7f090075.setOnClickListener(null);
    view7f090075 = null;
  }
}
