package com.huseyinkiran.simplescore.presentation.leagueList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel

@Composable
fun LeagueListContent(leagueList: List<LeagueUIModel>, onLeagueClick: (LeagueUIModel) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(leagueList) { league ->
            LeagueItem(league, onLeagueClick = {
                onLeagueClick(it)
            })
        }
    }
}

@Composable
fun LeagueItem(league: LeagueUIModel, onLeagueClick: (LeagueUIModel) -> Unit) {

    Box(modifier = Modifier.clickable {
        onLeagueClick(league)
    }) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(league.imageRes),
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = league.league, modifier = Modifier.weight(0.8f))
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = "")
        }
    }
    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

}