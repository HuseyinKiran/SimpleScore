package com.huseyinkiran.simplescore.presentation.leagueList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huseyinkiran.simplescore.domain.repository.FootballRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueListViewModel @Inject constructor(
    private val repository: FootballRepository
) : ViewModel() {

    private val _leagueList = MutableStateFlow(LeagueListUIState())
    val leagueList: StateFlow<LeagueListUIState> = _leagueList

    init {
        fetchLeagueList()
    }

    fun fetchLeagueList() = viewModelScope.launch {
        _leagueList.value = LeagueListUIState(isLoading = true)
        try {
            val response = repository.getLeagues()
            _leagueList.value = LeagueListUIState(isLoading = false, leagueList = response)
        } catch (e: Exception) {
            _leagueList.value = LeagueListUIState(isLoading = false, errorMessage = "İnternet bağlantınızı kontrol ediniz")
        }
    }

}