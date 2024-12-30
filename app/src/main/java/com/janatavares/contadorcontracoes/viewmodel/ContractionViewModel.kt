package com.janatavares.contadorcontracoes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.janatavares.contadorcontracoes.data.model.Contraction
//import com.janatavares.contadorcontracoes.data.repository.ContractionRepository
//import com.janatavares.contadorcontracoes.domain.ContractionManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ContractionViewModel() : ViewModel() {

    private val _isContractionStarted = MutableStateFlow(false)
    val isContractionStarted: StateFlow<Boolean> = _isContractionStarted

    fun toggleContractionState(){
        _isContractionStarted.value = !_isContractionStarted.value
    }

/*
    private val contractionManager = ContractionManager()

    fun addContraction(contraction: Contraction) {
        viewModelScope.launch {
            repository.insertContraction(contraction)
            contractionManager.addContraction(contraction)
        }
    }*/

    /*fun getStatistics(): Map<String, Int> {
        val lastHour = contractionManager.getLastHourContractions().size
        val averageDuration = contractionManager.getAverageDuration()
        //val frequency = contractionManager.getFrequency()

        return mapOf(
            "lastHour" to lastHour,
            "averageDuration" to averageDuration,
            //"frequency" to frequency
        )
    }*/
}