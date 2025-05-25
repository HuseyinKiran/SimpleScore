package com.huseyinkiran.simplescore.presentation.leagueStanding.mapper

import com.huseyinkiran.simplescore.data.model.TeamStanding
import com.huseyinkiran.simplescore.presentation.leagueStanding.model.TeamStandingUIModel

fun TeamStanding.toUIModel(): TeamStandingUIModel {
    return TeamStandingUIModel(
        rank = rank,
        draw = draw,
        lose = lose,
        win = win,
        play = play,
        point = point,
        goalFor = goalfor,
        goalAgainst = goalagainst,
        goalDistance = goaldistance,
        team = team
    )
}