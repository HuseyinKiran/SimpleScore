package com.huseyinkiran.simplescore.presentation.leagueList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huseyinkiran.simplescore.domain.repository.FootballRepository
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueListViewModel @Inject constructor
    (private val repository: FootballRepository) : ViewModel() {

    private val _leagueList = MutableStateFlow<List<LeagueUIModel>>(emptyList())
    val leagueList: StateFlow<List<LeagueUIModel>> = _leagueList

    init {
        fetchLeagueList()
    }

    fun fetchLeagueList() = viewModelScope.launch {
        try {
            val response = repository.getLeagues()
            _leagueList.value = response
        } catch (e: Exception) {
            e.message?.let { Log.d("LeaguesViewModel", it) }
        }

    }

}