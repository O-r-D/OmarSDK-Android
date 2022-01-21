package com.ord.omarlib.data

import com.ord.omarlib.data.model.SurveyCheck
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface BitLabAPI {

    @GET("client/check?platform=MOBILE")
    fun checkSurveys(@Header("X-Api-Token") token: String, @Header("X-User-Id") id: String): Call<SurveyCheck>

    companion object {
        operator fun invoke(): BitLabAPI =
            Retrofit.Builder()
                .baseUrl("https://api.bitlabs.ai/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BitLabAPI::class.java)

    }

}