package com.example.gomoneytakehome.data.remote

import com.example.gomoneytakehome.data.ApiClient
import com.example.gomoneytakehome.data.ApiClient.api

class FootballRepository {

    suspend fun getAllCompetition() = api.getAllCompetition()
}