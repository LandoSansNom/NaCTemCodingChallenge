package com.example.nactemcodingchallenge.data.remote

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiCall{
    @GET(".")
    fun getStringResponse(@Query("sf") sf: String): Call<String>
}