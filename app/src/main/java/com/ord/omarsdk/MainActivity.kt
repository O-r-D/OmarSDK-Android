package com.ord.omarsdk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ord.omarlib.OmarLib
import com.ord.omarlib.ResponseListener

class MainActivity : AppCompatActivity() {

    private val omarLib = OmarLib(this, "a8ef5ffc-f8eb-4186-8652-637f08920ddc", "0")
    private val TAG = "MAINACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        omarLib.checkForSurveys(object : ResponseListener {
            override fun onResponse(hasSurveys: Boolean) {
                Log.i(TAG, if (hasSurveys) "YOU HAVE SURVEYS!" else "YOU DON'T HAVE SURVEYS")
            }

            override fun onFailure(error: Throwable) {
                Log.e(TAG, error.toString())
            }
        })

        omarLib.loadSurvey()
    }


}