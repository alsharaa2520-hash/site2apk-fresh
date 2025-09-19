package com.syriaapps.template;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.*;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
  private WebView web;
  @SuppressLint("SetJavaScriptEnabled")
  protected void onCreate(Bundle b){
    super.onCreate(b);
    web = new WebView(this);
    setContentView(web);
    WebSettings s = web.getSettings();
    s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true);
    s.setDatabaseEnabled(true); s.setAllowFileAccess(true);
    s.setLoadWithOverviewMode(true); s.setUseWideViewPort(true);
    CookieManager.getInstance().setAcceptCookie(true);
    web.setWebViewClient(new WebViewClient());
    web.setWebChromeClient(new WebChromeClient());
    String url = BuildConfig.SITE_URL;
    if (url==null || url.trim().isEmpty()) url = "https://syriaapps.store";
    web.loadUrl(url);
  }
  public void onBackPressed(){ if (web!=null && web.canGoBack()) web.goBack(); else super.onBackPressed(); }
}
