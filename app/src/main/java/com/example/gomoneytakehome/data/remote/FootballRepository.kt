package com.example.gomoneytakehome.data.remote

import com.example.gomoneytakehome.data.ApiClient

class FootballRepository(
    val api: FootballService = ApiClient.retrofit.create(FootballService::class.java)
) {

    suspend fun getAllCompetition() = api.getAllCompetition()
}