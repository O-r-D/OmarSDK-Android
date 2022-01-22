package com.ord.omarlib

import android.content.Context
import android.content.Intent
import android.util.Log
import android.webkit.WebView
import com.ord.omarlib.data.BitLabAPI
import com.ord.omarlib.data.model.SurveyCheck
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OmarLib(private val context: Context, private val token: String, private val id: String) {

    private val TAG = "OMARLIB"

    fun checkForSurveys() {
        BitLabAPI().checkSurveys(token, id).enqueue(object : Callback<SurveyCheck> {
            override fun onResponse(call: Call<SurveyCheck>, response: Response<SurveyCheck>) {
                if (response.isSuccessful)
                    Log.i(TAG, response.body()!!.toString())
                else
                    Log.e(TAG, response.errorBody().toString())
            }

            override fun onFailure(call: Call<SurveyCheck>, t: Throwable) {
                Log.e(TAG, t.toString())
            }

        })
    }

    fun loadSurvey() {
        val intent = Intent(context, WebViewActivity::class.java)
        context.startActivity(intent)
    }
}

