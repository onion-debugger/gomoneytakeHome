package com.example.gomoneytakehome.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gomoneytakehome.data.remote.FootballRepository
import com.example.gomoneytakehome.data.remote.FootballService
import java.lang.IllegalArgumentException

class VMFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompetitionVM::class.java)) {
            return CompetitionVM(FootballRepository()) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}