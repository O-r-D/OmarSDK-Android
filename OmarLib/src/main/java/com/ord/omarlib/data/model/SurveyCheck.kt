package com.ord.omarlib.data.model

data class SurveyCheck(
    val data: SurveyData,
    val error: SurveyError,
    val status: String,
    val trace_id: String
)


data class SurveyData(val has_surveys: Boolean)

data class SurveyError(val details: ErrorDetails)

data class ErrorDetails(
    val http: String,
    val msg: String
)