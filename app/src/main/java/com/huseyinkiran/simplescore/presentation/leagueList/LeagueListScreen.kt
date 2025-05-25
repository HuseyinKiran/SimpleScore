package com.huseyinkiran.simplescore.presentation.leagueList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.huseyinkiran.simplescore.utils.LeagueFilter
import com.huseyinkiran.simplescore.presentation.navigation.Screen

@Composable
fun LeagueListScreen(navController: NavController) {
    val viewModel: LeagueListViewModel = hiltViewModel()
    val leagueList by viewModel.leagueList.collectAsState()

    val filteredList = leagueList.filter { it.key in LeagueFilter.showLeagues }

    LeagueListContent(leagueList = filteredList, onLeagueClick = { league ->
        navController.navigate(Screen.LeagueTabs.createRoute(league.key, league.league))
    })
}