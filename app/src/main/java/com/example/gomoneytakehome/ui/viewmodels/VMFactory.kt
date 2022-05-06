package com.example.gomoneytakehome.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gomoneytakehome.data.FootballRepository
import com.example.gomoneytakehome.local.dao.CompetitionDao
import java.lang.IllegalArgumentException

class VMFactory(private val dao: CompetitionDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompetitionVM::class.java)) {
            return CompetitionVM(FootballRepository(dao)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}