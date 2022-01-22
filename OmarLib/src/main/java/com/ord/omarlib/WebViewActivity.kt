package com.ord.omarlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ord.omarlib.databinding.ActivityWebviewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val surveysWebview = binding.wvSurveys

        surveysWebview.loadUrl("https://www.google.com")
    }
}