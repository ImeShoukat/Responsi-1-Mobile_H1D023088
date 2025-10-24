package com.example.responsi1mobileh1d023088.data.network

import com.example.responsi1mobileh1d023088.data.model.entity.Team
import retrofit2.Response
import retrofit2.http.GET

interface FootBallAPI {
    @GET("teams/325")
    suspend fun getTeam(): Response<Team>
}