package com.huseyinkiran.simplescore.presentation.leagueList.model

import com.huseyinkiran.simplescore.utils.LeagueImageProvider

data class LeagueUIModel(
    val league: String,
    val key: String,
    val imageRes: Int = LeagueImageProvider.getImageResource(key)
)