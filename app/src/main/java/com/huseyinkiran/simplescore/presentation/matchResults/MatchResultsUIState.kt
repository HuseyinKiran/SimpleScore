package com.huseyinkiran.simplescore.presentation.matchResults

import com.huseyinkiran.simplescore.presentation.matchResults.model.MatchResultUIModel

data class MatchResultsUIState(
    val isLoading: Boolean = false,
    val matchResults: List<MatchResultUIModel> = emptyList(),
    val errorMessage: String? = null
)
