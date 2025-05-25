package com.huseyinkiran.simplescore.data.model

data class MatchResult(val skor: String, val date: String, val away: String, val home: String)

data class MatchResultResponse(val success: Boolean, val result: List<MatchResult>)