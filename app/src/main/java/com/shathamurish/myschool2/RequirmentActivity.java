package com.shathamurish.myschool2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class RequirmentActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirment);
        webView =findViewById(R.id.gif);
        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file="file:android_asset/gifmaker8.gif";
        webView.loadUrl(file);



    }
}