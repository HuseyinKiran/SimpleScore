package com.huseyinkiran.simplescore.presentation.matchResults

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MatchResultsScreen(leagueKey: String, league: LeagueUIModel) {

    val viewModel: MatchResultsViewModel = hiltViewModel()
    val state by viewModel.matchResults.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchMatchResults(leagueKey)
    }

    MatchResultsContent(
        league = league,
        matchResults = state.matchResults,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage
    )

}