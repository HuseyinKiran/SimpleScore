package com.huseyinkiran.simplescore.presentation.matchResults

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.huseyinkiran.simplescore.presentation.goalKings.LeagueInfoLayout
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel
import com.huseyinkiran.simplescore.presentation.matchResults.model.MatchResultUIModel
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MatchResultsContent(league: LeagueUIModel, matchResults: List<MatchResultUIModel>) {
    Column(modifier = Modifier.fillMaxSize()) {
        LeagueInfoLayout(league = league)
        MatchResultsBar()
        LazyColumn {
            items(matchResults) {
                MatchResultItem(it)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MatchResultsBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Text(
            text = "Fikstür",
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MatchResultItem(matchResult: MatchResultUIModel) = with(matchResult) {

    val formattedDate = try {
        val parsedDate = OffsetDateTime.parse(date).plusHours(3)
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale("tr"))
        formatter.format(parsedDate)
    } catch (e: Exception) {
        date
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = formattedDate,
            modifier = Modifier.weight(0.20f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.weight(0.025f))
        Text(
            text = home,
            modifier = Modifier.weight(0.275f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = if (score == "undefined-undefined") "V" else score,
            modifier = Modifier.weight(0.20f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = away,
            modifier = Modifier.weight(0.275f),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.weight(0.025f))
    }
    HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp))
}