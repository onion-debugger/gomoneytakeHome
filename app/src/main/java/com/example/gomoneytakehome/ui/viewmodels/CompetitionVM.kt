package com.example.gomoneytakehome.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomoneytakehome.data.model.CompetitionModel
import com.example.gomoneytakehome.data.remote.FootballRepository
import com.example.gomoneytakehome.util.NetworkResult

class CompetitionVM(
    private val footballRepository: FootballRepository
) : ViewModel() {

    init {

    }

    var response: MutableLiveData<NetworkResult<CompetitionModel>> = MutableLiveData()

    private fun fetchCompetitions() {
        if (hasIn)
    }

}