package com.huseyinkiran.simplescore.presentation.matchResults.mapper

import com.huseyinkiran.simplescore.data.model.MatchResult
import com.huseyinkiran.simplescore.presentation.matchResults.model.MatchResultUIModel

fun MatchResult.toUIModel(): MatchResultUIModel {
    return MatchResultUIModel(score = skor, date = date, away = away, home = home)
}