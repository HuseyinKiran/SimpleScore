package com.huseyinkiran.simplescore.data.model

data class GoalKing(val name: String, val goals: String)

data class GoalKingsResponse(val success: Boolean, val result: List<GoalKing>)