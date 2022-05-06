package com.example.gomoneytakehome.data.remote

import com.example.gomoneytakehome.data.model.CompetitionModel
import retrofit2.Response
import retrofit2.http.GET

interface FootballService {

    @GET("competitions")
    suspend fun getAllCompetition(): Response<CompetitionModel>
}