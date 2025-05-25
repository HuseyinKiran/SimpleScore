package com.huseyinkiran.simplescore.presentation.goalKings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel

@Composable
fun GoalKingsScreen(leagueKey: String, league: LeagueUIModel) {

    val viewModel: GoalKingsViewModel = hiltViewModel()
    val goalKings by viewModel.goalKings.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchGoalKings(leagueKey)
    }

    GoalKingsContent(league = league, goalKings = goalKings)
}