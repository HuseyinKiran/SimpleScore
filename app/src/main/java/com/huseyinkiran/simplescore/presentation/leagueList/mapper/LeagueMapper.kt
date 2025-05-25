package com.huseyinkiran.simplescore.presentation.leagueList.mapper

import com.huseyinkiran.simplescore.data.model.League
import com.huseyinkiran.simplescore.presentation.leagueList.model.LeagueUIModel
import com.huseyinkiran.simplescore.utils.LeagueImageProvider

fun League.toUIModel(): LeagueUIModel {
    return LeagueUIModel(
        league = league,
        key = key,
        imageRes = LeagueImageProvider.getImageResource(key)
    )
}