package com.huseyinkiran.simplescore.presentation.leagueStanding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.huseyinkiran.simplescore.presentation.goalKings.LeagueInfoLayout
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel
import com.huseyinkiran.simplescore.presentation.leagueStanding.model.TeamStandingUIModel

@Composable
fun LeagueStandingContent(league: LeagueUIModel, teamList: List<TeamStandingUIModel>) {
    Column(modifier = Modifier.fillMaxSize()) {
        LeagueInfoLayout(league = league)
        LeagueStandingBar()
        LazyColumn {
            items(teamList) {
                TeamRankItem(teamStanding = it)
            }
        }
    }

}

@Composable
fun LeagueStandingBar() {
    Box(modifier = Modifier.background(Color.DarkGray)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            Text(
                text = "Sıra",
                modifier = Modifier.weight(0.1f),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "Takım",
                modifier = Modifier.weight(0.34f),
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "O", modifier = Modifier.weight(0.07f), textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "G", modifier = Modifier.weight(0.07f), textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "B", modifier = Modifier.weight(0.07f), textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "M", modifier = Modifier.weight(0.07f), textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "A", modifier = Modifier.weight(0.07f), textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "Y", modifier = Modifier.weight(0.07f), textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "Av", modifier = Modifier.weight(0.07f), textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "P", modifier = Modifier.weight(0.07f), textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun TeamRankItem(teamStanding: TeamStandingUIModel) = with(teamStanding) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
    ) {
        Text(
            text = "$rank.",
            modifier = Modifier.weight(0.1f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Text(
            text = team,
            modifier = Modifier.weight(0.34f),
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "$play",
            modifier = Modifier.weight(0.07f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Text(
            text = "$win",
            modifier = Modifier.weight(0.07f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Text(
            text = "$draw",
            modifier = Modifier.weight(0.07f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Text(
            text = "$lose",
            modifier = Modifier.weight(0.07f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Text(
            text = "$goalFor",
            modifier = Modifier.weight(0.07f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Text(
            text = "$goalAgainst",
            modifier = Modifier.weight(0.07f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Text(
            text = "$goalDistance",
            modifier = Modifier.weight(0.07f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Text(
            text = "$point",
            modifier = Modifier.weight(0.07f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
    HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp))
}