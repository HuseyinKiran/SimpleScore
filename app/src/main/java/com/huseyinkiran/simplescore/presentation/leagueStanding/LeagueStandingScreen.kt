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
    val leagueStanding by viewModel.leagueStanding.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchLeagueStanding(leagueKey)
    }

    LeagueStandingContent(league = league, teamList = leagueStanding)
}