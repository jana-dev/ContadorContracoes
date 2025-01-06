// Pacote: viewmodel
package com.janatavares.contadorcontracoes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainScreenViewModel(application: Application) : AndroidViewModel(application) {

    // Controla se a contração está ativa ou não
    private val _isContractionStarted = MutableStateFlow(false)
    val isContractionStarted: StateFlow<Boolean> get() = _isContractionStarted

    // Controla a exibição da mensagem inicial
    private val _showInitialMessage = MutableStateFlow(true)
    val showInitialMessage: StateFlow<Boolean> get() = _showInitialMessage

    // Iniciar uma contração
    fun startContraction() {
        _isContractionStarted.value = true
        _showInitialMessage.value = false
    }

    // Parar uma contração
    fun stopContraction() {
        _isContractionStarted.value = false
    }
}
