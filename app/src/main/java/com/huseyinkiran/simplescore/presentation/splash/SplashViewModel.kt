package com.huseyinkiran.simplescore.presentation.splash

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {

    private val _navigateToLeagueList = mutableStateOf(false)
    val navigateToLeagueList: State<Boolean> = _navigateToLeagueList

    init {
        initiateSplashFlow()
    }

    private fun initiateSplashFlow() = viewModelScope.launch {
        delay(2000)
        _navigateToLeagueList.value = true
    }

}