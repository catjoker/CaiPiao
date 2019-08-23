// Generated code from Butter Knife. Do not modify!
package com.BASofttech.caipiao.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.BASofttech.caipiao.R;
import com.tencent.smtt.sdk.WebView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Fragment_Gift_ViewBinding implements Unbinder {
  private Fragment_Gift target;

  @UiThread
  public Fragment_Gift_ViewBinding(Fragment_Gift target, View source) {
    this.target = target;

    target.webview = Utils.findRequiredViewAsType(source, R.id.webview, "field 'webview'", WebView.class);
    target.iv_text = Utils.findRequiredViewAsType(source, R.id.tv_text, "field 'iv_text'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Fragment_Gift target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.webview = null;
    target.iv_text = null;
  }
}
