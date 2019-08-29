package com.BASofttech.caipiao.ui.fragment;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.BASofttech.caipiao.R;
import com.bumptech.glide.Glide;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

public class Fragment_Gift extends BaseFragment {
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.tv_text)
    AppCompatTextView iv_text;
    CookieManager mCookieManager;
    private final int WEB_GOBACK = 1;

    @Override
    protected int setLayout() {
        return R.layout.activity_dlt;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case WEB_GOBACK: {
                    webview.goBack();
                }
                break;
                default:
                    break;
            }
        }
    };


    @Override
    protected void initView(View view) {
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//        webview.getSettings().setJavaScriptEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.getSettings().setSupportZoom(true);  //支持放大缩小
        webview.getSettings().setDisplayZoomControls(false);//页面缩放加减号
        //     mWeb.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);  //缓存模式
        // String cacheDirPath = getFilesDir().getAbsolutePath() + APP_CACAHE_DIRNAME; //缓存路径
        //   mWeb.getSettings().setAppCachePath(cacheDirPath); //设置缓存路径
        webview.getSettings().setAppCacheEnabled(true); //开启缓存功能
        //        mCookieManager.setAcceptThirdPartyCookies(mWeb, true);
        webview.getSettings().setSaveFormData(true);// 保存表单数据
        //        mWeb.setWebViewClient(new WebViewClient());
        mCookieManager = CookieManager.getInstance();
        mCookieManager.setAcceptCookie(true);
        //        webview.addJavascriptInterface(new JavaScriptBridge(), "jsObj");
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
        webview.getSettings().setBlockNetworkImage(true);
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.setFocusable(true);
        webview.setFocusableInTouchMode(true);
        webview.requestFocus();

        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress < 100) {
                    //第一种第二种都可以加载gif
                    Glide.with(mContext)
                            .asGif()
                            .load(R.drawable.loading)
//                            .apply()
                            .into((AppCompatImageView) (loadingDialog.getWindow().findViewById(R.id.iv_loading)));
//                    Glide.with(mContext).load(R.drawable.loading).into((ImageView) (loadingDialog.getWindow().findViewById(R.id.iv_loading)));
                    loadingDialog.getWindow().setDimAmount(0f);//核心代码 解决了无法去除遮罩问题
                    loadingDialog.show();
                    if (view.getUrl().contains("moreexpect") || view.getUrl().contains("datachart"))
                        loadingDialog.dismiss();
                }
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                showToast(message);
                result.confirm();
                return true;
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                // if (null != title && !mWebView.getUrl().contains(title)) {
                // tvTitle.setText(title);
                // }
            }

        });

        webview.setWebViewClient(new WebViewClient() {


            @Override
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError sslError) {
                showToast("错误");
//                handler.proceed();
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                Log.e("request.getUrl()", request.getUrl().toString());
                /*return true 表示当前url即使是重定向url也不会再执行（除了在return true之前使用webview.loadUrl(url)除外，因为这个会重新加载）
                  return false  表示由系统执行url，直到不再执行此方法，即加载完重定向的url（即具体的url，不再有重定向）
                  简而言之  true支持重定向  false不支持181212
                */
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                //低版本无论false还是true 都重定向
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) webview.getLayoutParams();
                if (url.contains("moreexpect") || url.contains("datachart")) {
                    //获取当前控件的布局对象
                    params.height = WindowManager.LayoutParams.MATCH_PARENT;//设置当前控件布局的高度
                    loadingDialog.dismiss();
                } else {
                    params.height = WindowManager.LayoutParams.WRAP_CONTENT;//设置当前控件布局的高度
                }
                webview.setLayoutParams(params);//将设置好的布局参数应用到控件中
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (webview.getProgress() == 100) {
                    // 这个是一定要加上那个的,配合scrollView和WebView的height=wrap_content属性使用
                    int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    // 重新测量
                    webview.measure(w, h);

                    // 编写 javaScript方法 html移除广告和标题180612
                    String javascript = "javascript:function hideOther() {"
                            + "var a = document.getElementById('uiHead');"
                            + "a.parentNode.removeChild(a);"
                            + "}";
                    String javascript2 = "javascript:function hideOther2() {"
                            + "var b = document.getElementById('touch-nav');"
                            + "b.parentNode.removeChild(b);"
                            + "}";
                    String javascript3 = "javascript:function hideOther3() {"
                            + "var c = document.getElementById('ui-banner-scroll');"
                            + "c.parentNode.removeChild(c);"
                            + "}";
                    String javascript4 = "javascript:function marginTopOther() {"
                            + "var d = document.getElementById('wrap');"
                            + "d.parentNode.style.marginTop = '35px';"
                            + "}";
//
//                    // 创建方法
                    webview.loadUrl(javascript);
                    webview.loadUrl(javascript2);
                    webview.loadUrl(javascript3);
                    webview.loadUrl(javascript4);
//
//                    // 加载方法
                    webview.loadUrl("javascript:hideOther();");
                    webview.loadUrl("javascript:hideOther2();");
                    webview.loadUrl("javascript:hideOther3();");
                    webview.loadUrl("javascript:marginTopOther();");
                    loadingDialog.dismiss();
                    webview.getSettings().setBlockNetworkImage(true);
                }
            }
        });
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://m.500.com/info/kaijiang/");//加载开奖数据180612
        iv_text.setText("开奖信息");
    }

    @Override
    protected void initData() {
        webview.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) { //只处理一次
                        handler.sendEmptyMessage(WEB_GOBACK);
                    }
                    return true;
                }
                return false;
            }

        });
    }

    @Override
    public void onPause() {
        webview.pauseTimers();
        super.onPause();
    }

    @Override
    public void onResume() {
        webview.resumeTimers();
        super.onResume();
    }
}
