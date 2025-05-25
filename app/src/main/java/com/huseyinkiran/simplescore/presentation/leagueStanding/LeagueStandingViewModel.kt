package com.huseyinkiran.simplescore.presentation.leagueStanding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huseyinkiran.simplescore.domain.repository.FootballRepository
import com.huseyinkiran.simplescore.presentation.leagueStanding.model.TeamStandingUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueStandingViewModel @Inject constructor
    (private val repository: FootballRepository) : ViewModel() {

    private val _leagueStanding = MutableStateFlow<List<TeamStandingUIModel>>(emptyList())
    val leagueStanding: StateFlow<List<TeamStandingUIModel>> = _leagueStanding

    fun fetchLeagueStanding(leagueKey: String) = viewModelScope.launch {
        try {
            val response = repository.getLeagueDetails(leagueKey)
            _leagueStanding.value = response
        } catch (e: Exception) {
            e.message?.let { Log.d("LeagueStandingViewModel", it) }
        }
    }

}