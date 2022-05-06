package com.example.gomoneytakehome.data.model

data class Competition(
    val area: Area,
    val code: Any,
    val currentSeason: CurrentSeason,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val numberOfAvailableSeasons: Int,
    val plan: String
)