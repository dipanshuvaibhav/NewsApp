package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    public static String WEBSITE_ADDRESS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url  = getIntent().getStringExtra(WEBSITE_ADDRESS);
        if (url == null || url.isEmpty()) finish();

        setContentView(R.layout.activity_web_view);
        WebView webView = (WebView) findViewById(R.id.nyc_poi_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}