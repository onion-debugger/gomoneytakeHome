package com.example.gomoneytakehome.data

import androidx.lifecycle.LiveData
import com.example.gomoneytakehome.data.ApiClient.api
import com.example.gomoneytakehome.data.model.Competition
import com.example.gomoneytakehome.data.model.CompetitionModel
import com.example.gomoneytakehome.local.dao.CompetitionDao
import com.example.gomoneytakehome.local.entity.CompetitionsEntity
import retrofit2.Response

class FootballRepository(private val competitionDao: CompetitionDao) {

    suspend fun getAllCompetition() : Response<CompetitionModel> {
        return api.getAllCompetition().apply {
            if (isSuccessful) {
                body()?.competitions?.toMutableList()?.let { competition ->
                    saveCompetitions(
                        competition
                    )
                }
            }
        }
    }

    private suspend fun insertCompetition(competition: CompetitionsEntity) {
        competitionDao.insertCompetitions(competition)
    }

    private suspend fun saveCompetitions(competitions: MutableList<Competition>) {
        competitions.map {
            val competition = CompetitionsEntity(
                id = it.id,
                lastUpdated = it.lastUpdated,
                name = it.name,
                numberOfAvailableSeasons = it.numberOfAvailableSeasons,
                plan = it.plan
            )
            insertCompetition(competition)
        }
    }

    fun loadLocallyStoredCompetitions() : LiveData<CompetitionsEntity> {
        return competitionDao.getAllCompetitions()
    }

}