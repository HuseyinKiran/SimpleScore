package com.huseyinkiran.simplescore.presentation.leagueStanding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel

@Composable
fun LeagueStandingScreen(leagueKey: String, league: LeagueUIModel) {

    val viewModel: LeagueStandingViewModel = hiltViewModel()
    val state by viewModel.leagueStanding.collectAsState()

    LaunchedEffect(leagueKey) {
        viewModel.fetchLeagueStanding(leagueKey)
    }

    LeagueStandingContent(
        league = league,
        teamList = state.teamsStanding,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage
    )

}