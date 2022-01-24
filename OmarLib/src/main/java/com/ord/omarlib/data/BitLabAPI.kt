package com.ord.omarlib.data

import com.ord.omarlib.data.model.SurveyCheck
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * An interface that is responsible for all network communication with BitLabs API
 */
interface BitLabAPI {

    @GET("client/check?platform=MOBILE")
    fun checkSurveys(@Header("X-Api-Token") token: String, @Header("X-User-Id") id: String): Call<SurveyCheck>

    companion object {
        /**
         * A companion object to make this interface a singleton, as more than one instance isn't needed.
         */
        operator fun invoke(): BitLabAPI =
            Retrofit.Builder()
                .baseUrl("https://api.bitlabs.ai/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BitLabAPI::class.java)

    }

}