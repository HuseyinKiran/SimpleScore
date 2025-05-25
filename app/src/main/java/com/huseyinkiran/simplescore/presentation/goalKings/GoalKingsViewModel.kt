package com.huseyinkiran.simplescore.presentation.goalKings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huseyinkiran.simplescore.domain.repository.FootballRepository
import com.huseyinkiran.simplescore.presentation.goalKings.model.GoalKingUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalKingsViewModel @Inject constructor(private val repository: FootballRepository): ViewModel() {

    private val _goalKings = MutableStateFlow<List<GoalKingUIModel>>(emptyList())
    val goalKings: StateFlow<List<GoalKingUIModel>> = _goalKings

    fun fetchGoalKings(leagueKey: String) = viewModelScope.launch {
        try {
            val response = repository.getGoalKings(leagueKey)
            _goalKings.value = response
        } catch (e: Exception) {

        }
    }

}