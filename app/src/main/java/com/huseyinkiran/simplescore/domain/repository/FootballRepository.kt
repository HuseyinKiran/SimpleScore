package com.huseyinkiran.simplescore.domain.repository

import com.huseyinkiran.simplescore.presentation.goalKings.model.GoalKingUIModel
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel
import com.huseyinkiran.simplescore.presentation.leagueStanding.model.TeamStandingUIModel
import com.huseyinkiran.simplescore.presentation.matchResults.model.MatchResultUIModel

interface FootballRepository {

    suspend fun getLeagues(): List<LeagueUIModel>

    suspend fun getLeagueDetails(leagueKey: String): List<TeamStandingUIModel>

    suspend fun getMatchResults(leagueKey: String): List<MatchResultUIModel>

    suspend fun getGoalKings(leagueKey: String): List<GoalKingUIModel>

}