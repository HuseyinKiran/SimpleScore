package com.huseyinkiran.simplescore.presentation.goalKings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huseyinkiran.simplescore.domain.repository.FootballRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalKingsViewModel @Inject constructor(
    private val repository: FootballRepository
) : ViewModel() {

    private val _goalKings = MutableStateFlow(GoalKingsUIState())
    val goalKings: StateFlow<GoalKingsUIState> = _goalKings

    fun fetchGoalKings(leagueKey: String) = viewModelScope.launch {
        if (goalKings.value.goalKings.isNotEmpty()) return@launch

        _goalKings.value = GoalKingsUIState(isLoading = true)
        try {
            val response = repository.getGoalKings(leagueKey)
            _goalKings.value = GoalKingsUIState(isLoading = false, goalKings = response)
        } catch (e: Exception) {
            _goalKings.value = GoalKingsUIState(errorMessage = "İnternet bağlantınızı kontrol ediniz")
        }
    }

}