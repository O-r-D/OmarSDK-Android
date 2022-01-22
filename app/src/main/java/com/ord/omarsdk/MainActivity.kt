package com.ord.omarsdk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ord.omarlib.OmarLib
import com.ord.omarlib.WebViewActivity

class MainActivity : AppCompatActivity() {

    val omarLib = OmarLib(this,"a8ef5ffc-f8eb-4186-8652-637f08920ddc","0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        omarLib.checkForSurveys()

        omarLib.loadSurvey()
    }


}