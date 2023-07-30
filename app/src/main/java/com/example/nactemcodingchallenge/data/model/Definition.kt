package com.example.nactemcodingchallenge.data.model

import com.google.gson.annotations.SerializedName

data class Definition(
    @SerializedName("freq")
    val frequence: Int? = 0,
    @SerializedName("lf")
    val definition: String? = "",
    @SerializedName("since")
    val since: Int? = 0
)