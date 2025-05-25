package com.huseyinkiran.simplescore.presentation.navigation

sealed class Screen(val route: String) {
    data object SplashScreen: Screen("splash")
    data object LeagueList: Screen("league_list")
    data object LeagueTabs: Screen("league_tabs/{leagueKey}/{leagueName}") {
        fun createRoute(leagueKey: String, leagueName: String) = "league_tabs/$leagueKey/$leagueName"
    }
}