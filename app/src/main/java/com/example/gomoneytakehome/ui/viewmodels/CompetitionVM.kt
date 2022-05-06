package com.example.gomoneytakehome.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gomoneytakehome.data.model.CompetitionModel
import com.example.gomoneytakehome.data.remote.FootballRepository
import com.example.gomoneytakehome.util.NetworkResult
import kotlinx.coroutines.launch

class CompetitionVM(
    private val footballRepository: FootballRepository
) : ViewModel() {

    init {
        fetchCompetitions()
    }

    var response: MutableLiveData<NetworkResult<CompetitionModel>> = MutableLiveData()

    private fun fetchCompetitions() {
        viewModelScope.launch {
            try {
                val res = footballRepository.getAllCompetition()
                if(res.isSuccessful && res.body() != null) {
                    response.value = NetworkResult.Success(res.body()!!)
                } else {
                    response.value = NetworkResult.Error(code = res.code(), res.message())
                }
            } catch (e: Throwable) {
                response.value = NetworkResult.Exception(e)
            }
        }

    }

}