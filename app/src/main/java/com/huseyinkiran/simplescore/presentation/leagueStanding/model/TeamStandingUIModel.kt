package com.huseyinkiran.simplescore.presentation.leagueStanding.model

data class TeamStandingUIModel(
    val rank: Int,
    val draw: Int,
    val lose: Int,
    val win: Int,
    val play: Int,
    val point: Int,
    val goalFor: Int,
    val goalAgainst: Int,
    val goalDistance: Int,
    val team: String
)