package com.huseyinkiran.simplescore.presentation.leagueStanding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huseyinkiran.simplescore.domain.repository.FootballRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueStandingViewModel @Inject constructor(
    private val repository: FootballRepository
) : ViewModel() {

    private val _leagueStanding = MutableStateFlow(LeagueStandingUIState())
    val leagueStanding: StateFlow<LeagueStandingUIState> = _leagueStanding

    fun fetchLeagueStanding(leagueKey: String) = viewModelScope.launch {
        if (leagueStanding.value.teamsStanding.isNotEmpty()) return@launch

        _leagueStanding.value = LeagueStandingUIState(isLoading = true)
        try {
            val response = repository.getLeagueDetails(leagueKey)
            _leagueStanding.value =
                LeagueStandingUIState(isLoading = false, teamsStanding = response)
        } catch (e: Exception) {
            _leagueStanding.value = LeagueStandingUIState(errorMessage = "İnternet bağlantınızı kontrol ediniz")
        }
    }

}