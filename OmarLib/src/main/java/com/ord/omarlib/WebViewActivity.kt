package com.ord.omarlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val surveysWebView = findViewById<WebView>(R.id.wv_surveys)

        surveysWebView.loadUrl("https://www.google.com")
    }
}