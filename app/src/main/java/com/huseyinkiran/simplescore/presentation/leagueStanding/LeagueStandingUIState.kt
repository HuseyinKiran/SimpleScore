package com.huseyinkiran.simplescore.presentation.leagueStanding

import com.huseyinkiran.simplescore.presentation.leagueStanding.model.TeamStandingUIModel

data class LeagueStandingUIState(
    val isLoading: Boolean = false,
    val teamsStanding: List<TeamStandingUIModel> = emptyList(),
    val errorMessage: String? = null
)
