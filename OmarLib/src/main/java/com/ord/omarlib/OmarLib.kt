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

/**
 * The main class that will be used by the developers to use all the functionality of OmarSDK
 *
 * @constructor
 * @param context The context of the activity in which this class will be instantiated.
 * @param token The authentication token used in accessing the backend.
 * @param id The user id used in authentication of communication with the API
 */
class OmarLib(private val context: Context, private val token: String, private val id: String) {

    private val TAG = "OMARLIB"

    /** This will check for surveys and run the code of [] when a response is received. */
    fun checkForSurveys(responseListener: ResponseListener) {
        BitLabAPI().checkSurveys(token, id).enqueue(object : Callback<SurveyCheck> {
            override fun onResponse(call: Call<SurveyCheck>, response: Response<SurveyCheck>) {
                if (response.isSuccessful && response.body()?.data != null) {
                    responseListener.onResponse(response.body()!!.data.has_surveys)
                    Log.i(TAG, response.body()!!.toString())
                } else
                    Log.e(TAG, response.errorBody().toString())
            }

            override fun onFailure(call: Call<SurveyCheck>, t: Throwable) {
                responseListener.onFailure(t)
            }

        })
    }

    fun loadSurvey() {
        val intent = Intent(context, WebViewActivity::class.java)
        context.startActivity(intent)
    }
}

