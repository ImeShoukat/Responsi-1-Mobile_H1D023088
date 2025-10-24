package com.example.responsi1mobileh1d023088.data.model.entity

import com.google.gson.annotations.SerializedName

data class Coach(
    @SerializedName("id")
    val id: Int,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("contract")
    val contract: Contract?
)

data class Contract(
    @SerializedName("start")
    val start: String?,
    @SerializedName("until")
    val until: String?
)

