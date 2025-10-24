package com.example.responsi1mobileh1d023088.data.model.entity

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("lastUpdated")
    val lastUpdated: String,

    @SerializedName("squad")
    val squad: List<Player>,

    @SerializedName("marketValue")
    val marketValue: Int,

    @SerializedName("area")
    val area: Area,

    @SerializedName("coach")
    val coach: Coach,

    @SerializedName("runningCompetitions")
    val runningCompetitions: List<Competition>
)
