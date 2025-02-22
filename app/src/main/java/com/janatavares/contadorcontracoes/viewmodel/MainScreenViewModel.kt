// Pacote: viewmodel
package com.janatavares.contadorcontracoes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Contraction(
    val startTime: String,
    val duration: String,
    val intensity: String? = null
)

class MainScreenViewModel(application: Application) : AndroidViewModel(application) {

    // Controla se a contração está ativa ou não
    private val _isContractionStarted = MutableStateFlow(false)
    val isContractionStarted: StateFlow<Boolean> get() = _isContractionStarted

    // Controla a exibição da mensagem inicial
    private val _showInitialMessage = MutableStateFlow(true)
    val showInitialMessage: StateFlow<Boolean> get() = _showInitialMessage

    private val _contractions = MutableStateFlow<List<Contraction>>(emptyList())
    val contractions: StateFlow<List<Contraction>> get() = _contractions

    // Novo estado para controlar o modal de intensidade
    private val _showIntensityDialog = MutableStateFlow(false)
    val showIntensityDialog: StateFlow<Boolean> get() = _showIntensityDialog

    private val _elapsedTime = MutableStateFlow(0)
    val elapsedTime: StateFlow<Int> get() = _elapsedTime

    private val _currentDuration = MutableStateFlow("0:00")
    val currentDuration: StateFlow<String> get() = _currentDuration

    private var startTime: String = ""


    // Iniciar uma contração
    fun startContraction() {
        _isContractionStarted.value = true
        _showInitialMessage.value = false

        // Zerar o tempo imediatamente antes de iniciar a contagem
        _elapsedTime.value = 0
        _currentDuration.value = "0:00"

        // Registrar horário de início
        startTime = SimpleDateFormat("HH:mm - dd/MM", Locale.getDefault()).format(Date())

        viewModelScope.launch {
            while (_isContractionStarted.value) {
                delay(1000)
                _elapsedTime.value += 1
                _currentDuration.value = formatDuration(_elapsedTime.value)
            }
        }
    }

    // Parar uma contração
    fun stopContraction() {
        _isContractionStarted.value = false
        _showIntensityDialog.value = true // Abrir o modal
    }

    // Novo método para salvar a contração com a intensidade selecionada
    fun saveContractionWithIntensity(intensity: String) {
        val duration = formatDuration(_elapsedTime.value)
        val newContraction = Contraction(
            startTime = startTime,
            duration = duration,
            intensity = intensity
        )
        _contractions.value = _contractions.value + newContraction

        _elapsedTime.value = 0
        _currentDuration.value = "0:00"
        _showIntensityDialog.value = false // Fechar o modal
    }

    private fun formatDuration(seconds: Int): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%d:%02d", minutes, remainingSeconds)
    }
}
