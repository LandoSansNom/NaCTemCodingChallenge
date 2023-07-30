package com.example.nactemcodingchallenge.data.repository

import android.util.Log
import com.example.nactemcodingchallenge.data.remote.ApiCall
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val apiCall: ApiCall
)
    : Repository{
    override fun getStringResponse(shortForm: String): Call<String> {
        val stringResponse: Call<String> = apiCall.getStringResponse(shortForm)
        stringResponse.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val data: String? = response.body()?.toString()
                    Log.d("response", data.toString())
                } else {
                    // Handle error
                }
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                // Handle failure
                Log.d("response", t.toString())
            }
        })

        return stringResponse
    }

}