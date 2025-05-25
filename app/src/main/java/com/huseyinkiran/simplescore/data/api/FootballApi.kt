package com.huseyinkiran.simplescore.data.api

import com.huseyinkiran.simplescore.data.model.GoalKingsResponse
import com.huseyinkiran.simplescore.data.model.LeagueListResponse
import com.huseyinkiran.simplescore.data.model.LeagueStandingsResponse
import com.huseyinkiran.simplescore.data.model.MatchResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballApi {

    @GET("leaguesList")
    suspend fun getLeagues(): LeagueListResponse

    @GET("league")
    suspend fun getLeagueDetails(@Query("data.league") leagueKey: String): LeagueStandingsResponse

    @GET("results")
    suspend fun getMatchResults(@Query("data.league") leagueKey: String): MatchResultResponse

    @GET("goalKings")
    suspend fun getGoalKings(@Query("data.league") leagueKey: String): GoalKingsResponse

}