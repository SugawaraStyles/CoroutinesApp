package com.example.coroutinesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var countTime by mutableStateOf(0)
        private set

    var secondCountTime by mutableStateOf(0)
        private set

    var resultState by mutableStateOf("")
        private set

    var isCounting by mutableStateOf(false)
        private set

    private var job: Job? = null

    private suspend fun startFirstCounter() {
        for (i in 1..5) {
            delay(1000)
            countTime = i
        }
    }

    private suspend fun startSecondCounter() {
        for (i in 1..5) {
            delay(1000)
            secondCountTime = i
        }
    }

    fun startCounters() {
        job = viewModelScope.launch {
            isCounting = true
            startFirstCounter()
            startSecondCounter()
            isCounting = false
        }
    }

    fun cancelCounters() {
        job?.cancel()
        isCounting = false
        resultState = "Contadores cancelados"
    }
}
