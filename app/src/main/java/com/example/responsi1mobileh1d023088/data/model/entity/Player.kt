package com.example.responsi1mobileh1d023088.data.model.entity

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("id")
    val id: Int,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("shirtNumber")
    val shirtNumber: Int,
    @SerializedName("marketValue")
    val marketValue: Int,
    @SerializedName("contract")
    val contract: Contract
    )


