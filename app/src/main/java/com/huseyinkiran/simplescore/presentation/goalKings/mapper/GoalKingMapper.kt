package com.huseyinkiran.simplescore.presentation.goalKings.mapper

import com.huseyinkiran.simplescore.data.model.GoalKing
import com.huseyinkiran.simplescore.presentation.goalKings.model.GoalKingUIModel

fun GoalKing.toUIModel(): GoalKingUIModel {
    return GoalKingUIModel(goals = goals, name = name)
}