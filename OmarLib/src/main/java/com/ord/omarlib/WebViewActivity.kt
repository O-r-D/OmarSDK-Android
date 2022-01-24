package com.ord.omarlib

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

/** The WebView activity that will display the surveys.
 *  This is a normal activity so it can be dismissed easily invoking back on the phone.
 **/
class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val surveysWebView = findViewById<WebView>(R.id.wv_surveys)

        surveysWebView.loadUrl("https://www.google.com")
    }
}