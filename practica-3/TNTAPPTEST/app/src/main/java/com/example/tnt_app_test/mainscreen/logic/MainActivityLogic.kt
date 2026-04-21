package com.example.tnt_app_test.mainscreen.logic

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var contador = mutableIntStateOf(0)
        private set

    fun incrementar() {
        contador.intValue++
    }
}