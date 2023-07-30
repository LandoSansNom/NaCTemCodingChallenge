package com.example.nactemcodingchallenge.data.repository

import okhttp3.ResponseBody
import retrofit2.Call

interface Repository{
     suspend fun getStringResponse(shortForm: String): Call<String>
}