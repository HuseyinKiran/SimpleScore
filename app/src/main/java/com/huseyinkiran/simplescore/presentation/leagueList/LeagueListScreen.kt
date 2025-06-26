package com.huseyinkiran.simplescore.presentation.leagueList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.huseyinkiran.simplescore.presentation.navigation.Screen
import com.huseyinkiran.simplescore.utils.LeagueFilter

@Composable
fun LeagueListScreen(navController: NavController) {

    val viewModel: LeagueListViewModel = hiltViewModel()
    val state by viewModel.leagueList.collectAsState()

    val filteredList = state.leagueList.filter { it.key in LeagueFilter.showLeagues }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            state.errorMessage != null -> {
                Text(
                    text = state.errorMessage ?: "Beklenmeyen bir hata oluştu",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                LeagueListContent(leagueList = filteredList, onLeagueClick = { league ->
                    navController.navigate(Screen.LeagueTabs.createRoute(league.key, league.league))
                })
            }

        }
    }

}