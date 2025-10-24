package com.example.responsi1mobileh1d023088.data.model.entity

import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName ("id")
    val id: Int,
    @SerializedName ("name")
    val name: String,
    @SerializedName ("code")
    val code: String,
    @SerializedName ("type")
    val type: String,
    @SerializedName("emblem")
    val emblem: String
)
