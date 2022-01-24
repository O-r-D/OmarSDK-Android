package com.ord.omarlib

interface ResponseListener {
    fun onResponse(hasSurveys: Boolean)
    fun onFailure(error: Throwable)
}