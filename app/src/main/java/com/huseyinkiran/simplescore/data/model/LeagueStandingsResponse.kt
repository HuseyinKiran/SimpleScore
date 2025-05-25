package com.huseyinkiran.simplescore.data.model

data class TeamStanding(
    val rank: Int,
    val draw: Int,
    val lose: Int,
    val win: Int,
    val play: Int,
    val point: Int,
    val goalfor: Int,
    val goalagainst: Int,
    val goaldistance: Int,
    val team: String
)

data class LeagueStandingsResponse(val success: Boolean, val result: List<TeamStanding>)