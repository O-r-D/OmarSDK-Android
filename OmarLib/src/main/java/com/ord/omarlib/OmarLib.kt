package com.ord.omarlib

import android.util.Log
import com.ord.omarlib.data.BitLabAPI
import com.ord.omarlib.data.model.SurveyCheck
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OmarLib(private val token: String, private val id: String) {
    fun checkForSurveys() {
        BitLabAPI().checkSurveys(token, id).enqueue(object : Callback<SurveyCheck> {
            override fun onResponse(call: Call<SurveyCheck>, response: Response<SurveyCheck>) {
                if (response.isSuccessful)
                    Log.i("RESPONSE SUCCESS", response.body()!!.toString())
                else
                    Log.i("RESPONSE FAILED", response.errorBody().toString())
            }

            override fun onFailure(call: Call<SurveyCheck>, t: Throwable) {
                Log.e("FAILURE", t.toString())
            }

        })
    }
}

