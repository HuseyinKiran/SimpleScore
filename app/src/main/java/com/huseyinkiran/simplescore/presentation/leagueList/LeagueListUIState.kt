package com.huseyinkiran.simplescore.presentation.leagueList

import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel

data class LeagueListUIState(
    val isLoading: Boolean = false,
    val leagueList: List<LeagueUIModel> = emptyList(),
    val errorMessage: String? = null
)
