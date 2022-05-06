package com.example.gomoneytakehome.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gomoneytakehome.data.model.CompetitionModel
import com.example.gomoneytakehome.local.entity.CompetitionsEntity

@Dao
interface CompetitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompetitions(competition: CompetitionsEntity)

    @Query("Select * FROM Competition ORDER BY name DESC")
    suspend fun getAllCompetitions() : CompetitionModel
}