package com.example.gomoneytakehome.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Competition")
data class CompetitionsEntity(
    @PrimaryKey
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val numberOfAvailableSeasons: Int,
    val plan: String
)
