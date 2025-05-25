package com.huseyinkiran.simplescore.presentation.leaguetabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.huseyinkiran.simplescore.R
import com.huseyinkiran.simplescore.presentation.goalKings.GoalKingsScreen
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel
import com.huseyinkiran.simplescore.presentation.leagueStanding.LeagueStandingScreen
import com.huseyinkiran.simplescore.presentation.matchResults.MatchResultsScreen

@Composable
fun LeagueTabsScreen(
    leagueKey: String,
    leagueName: String,
    viewModel: LeagueTabsViewModel = hiltViewModel()
) {

    val tabTitles = listOf("Puan Durumu", "Fikstür", "Gol Krallığı")
    val selectedTabIndex = viewModel.selectedTabIndex

    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
            contentColor = colorResource(R.color.app_bar_color),
            indicator = {}
        ) {
            tabTitles.forEachIndexed { index, title ->
                val isSelected = selectedTabIndex == index
                Tab(
                    selected = isSelected,
                    onClick = { viewModel.selectTab(index) },
                    modifier = Modifier.padding(4.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSelected) colorResource(R.color.app_bar_color) else Color.Transparent,
                            tonalElevation = if (isSelected) 2.dp else 0.dp,
                            modifier = Modifier.padding(
                                vertical = 2.dp, horizontal = 4.dp
                            )
                        ) {
                            Text(
                                text = title,
                                modifier = Modifier
                                    .padding(horizontal = 4.dp, vertical = 2.dp)
                                    .fillMaxWidth()
                                    .align(Alignment.Center),
                                color = if (isSelected) Color.White else Color.Black,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }

        val league = LeagueUIModel(league = leagueName, key = leagueKey)

        when (selectedTabIndex) {
            0 -> LeagueStandingScreen(
                leagueKey = leagueKey,
                league = league
            )

            1 -> MatchResultsScreen(
                leagueKey = leagueKey,
                league = league
            )

            2 -> GoalKingsScreen(
                leagueKey = leagueKey,
                league = league
            )
        }
    }
}