package com.huseyinkiran.simplescore.presentation.matchResults

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huseyinkiran.simplescore.domain.repository.FootballRepository
import com.huseyinkiran.simplescore.presentation.matchResults.model.MatchResultUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchResultsViewModel @Inject constructor(private val repository: FootballRepository): ViewModel() {

    private val _matchResults = MutableStateFlow<List<MatchResultUIModel>>(emptyList())
    val matchResults: StateFlow<List<MatchResultUIModel>> = _matchResults

    fun fetchMatchResults(leagueKey: String) = viewModelScope.launch {
        try {
            val response = repository.getMatchResults(leagueKey)
            _matchResults.value = response
        } catch (e: Exception) {

        }
    }

}