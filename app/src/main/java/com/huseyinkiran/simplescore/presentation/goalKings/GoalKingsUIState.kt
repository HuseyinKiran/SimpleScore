package com.huseyinkiran.simplescore.presentation.goalKings

import com.huseyinkiran.simplescore.presentation.goalKings.model.GoalKingUIModel

data class GoalKingsUIState(
    val isLoading: Boolean = false,
    val goalKings: List<GoalKingUIModel> = emptyList(),
    val errorMessage: String? = null
)
