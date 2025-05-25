package com.huseyinkiran.simplescore.data.model

data class League(val league: String, val key: String)

data class LeagueListResponse(val success: Boolean, val result: List<League>)