package com.huseyinkiran.simplescore.presentation.matchResults

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huseyinkiran.simplescore.domain.repository.FootballRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchResultsViewModel @Inject constructor(
    private val repository: FootballRepository
) : ViewModel() {

    private val _matchResults = MutableStateFlow(MatchResultsUIState())
    val matchResults: StateFlow<MatchResultsUIState> = _matchResults

    fun fetchMatchResults(leagueKey: String) = viewModelScope.launch {
        if (matchResults.value.matchResults.isNotEmpty()) return@launch

        _matchResults.value = MatchResultsUIState(isLoading = true)
        try {
            val response = repository.getMatchResults(leagueKey)
            _matchResults.value = MatchResultsUIState(isLoading = false, matchResults = response)
        } catch (e: Exception) {
            _matchResults.value = MatchResultsUIState(errorMessage = "İnternet bağlantınızı kontrol ediniz")
        }
    }

}