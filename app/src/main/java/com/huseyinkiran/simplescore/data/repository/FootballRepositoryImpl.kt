package com.huseyinkiran.simplescore.data.repository

import com.huseyinkiran.simplescore.data.api.FootballApi
import com.huseyinkiran.simplescore.domain.repository.FootballRepository
import com.huseyinkiran.simplescore.presentation.goalKings.mapper.toUIModel
import com.huseyinkiran.simplescore.presentation.goalKings.model.GoalKingUIModel
import com.huseyinkiran.simplescore.presentation.leagueList.mapper.toUIModel
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel
import com.huseyinkiran.simplescore.presentation.leagueStanding.mapper.toUIModel
import com.huseyinkiran.simplescore.presentation.leagueStanding.model.TeamStandingUIModel
import com.huseyinkiran.simplescore.presentation.matchResults.mapper.toUIModel
import com.huseyinkiran.simplescore.presentation.matchResults.model.MatchResultUIModel
import javax.inject.Inject

class FootballRepositoryImpl @Inject constructor(private val api: FootballApi) : FootballRepository {

    override suspend fun getLeagues(): List<LeagueUIModel> {
        val response = api.getLeagues()
        return if (response.success) response.result.map { it.toUIModel() } else emptyList()
    }

    override suspend fun getLeagueDetails(leagueKey: String): List<TeamStandingUIModel> {
        val response = api.getLeagueDetails(leagueKey)
        return if (response.success) response.result.map { it.toUIModel() } else emptyList()
    }

    override suspend fun getMatchResults(leagueKey: String): List<MatchResultUIModel> {
        val response = api.getMatchResults(leagueKey)
        return if (response.success) response.result.map { it.toUIModel() } else emptyList()
    }

    override suspend fun getGoalKings(leagueKey: String): List<GoalKingUIModel> {
        val response = api.getGoalKings(leagueKey)
        return if (response.success) response.result.map { it.toUIModel() } else emptyList()
    }

}