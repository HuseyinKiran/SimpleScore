package com.huseyinkiran.simplescore.presentation.goalKings

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.huseyinkiran.simplescore.presentation.goalKings.model.GoalKingUIModel
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel

@Composable
fun GoalKingsContent(
    league: LeagueUIModel,
    goalKings: List<GoalKingUIModel>,
    isLoading: Boolean,
    errorMessage: String?
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LeagueInfoLayout(league = league)
        GoalKingsBar()
        when {
            isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            errorMessage != null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = errorMessage.ifBlank { "Beklenmeyen bir hata oluştu" },
                        textAlign = TextAlign.Center,
                        color = Color.Red
                    )
                }
            }

            else -> {
                LazyColumn {
                    items(goalKings) {
                        GoalKingItem(it)
                    }
                }
            }
        }

    }
}

@Composable
fun LeagueInfoLayout(league: LeagueUIModel) {
    Row(modifier = Modifier.padding(16.dp)) {
        Image(
            painterResource(league.imageRes),
            contentDescription = "",
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = league.league, modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun GoalKingsBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Text(
            text = "Gol Krallığı",
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun GoalKingItem(goalKing: GoalKingUIModel) = with(goalKing) {
    val isLandscape = isLandscape()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = if (isLandscape) 24.dp else 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier.weight(0.9f),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = goals,
            modifier = Modifier.weight(0.1f),
            textAlign = TextAlign.End,
            fontSize = 12.sp,
            fontWeight = FontWeight.Black
        )
    }
    HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp))
}

@Composable
fun isLandscape(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}