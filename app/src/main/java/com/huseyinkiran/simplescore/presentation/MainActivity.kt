package com.huseyinkiran.simplescore.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.huseyinkiran.simplescore.R
import com.huseyinkiran.simplescore.presentation.leagueList.LeagueListScreen
import com.huseyinkiran.simplescore.presentation.leaguetabs.LeagueTabsScreen
import com.huseyinkiran.simplescore.presentation.splash.SplashScreen
import com.huseyinkiran.simplescore.ui.theme.SimpleScoreTheme
import com.huseyinkiran.simplescore.presentation.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleScoreTheme {
                SimpleScore()
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SimpleScore() {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val statusBarColor = colorResource(R.color.app_bar_color)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = false
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (currentRoute != Screen.SplashScreen.route) {
                CenterAlignedTopAppBar(
                    title = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "SimpleScore",
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }
                    },
                    navigationIcon = {
                        if (currentRoute == Screen.LeagueTabs.route) {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowLeft,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )
                            }
                        }
                    },
                    actions = {
                        if (currentRoute == Screen.LeagueTabs.route) {
                            Spacer(modifier = Modifier.size(48.dp))
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(R.color.app_bar_color),
                        titleContentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier.height(48.dp)
                )
            }
        }) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen.route,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(Screen.SplashScreen.route) {
                SplashScreen(navController = navController)
            }

            composable(Screen.LeagueList.route) {
                LeagueListScreen(navController = navController)
            }

            composable(
                Screen.LeagueTabs.route,
                arguments = listOf(
                    navArgument("leagueName") { type = NavType.StringType },
                    navArgument("leagueKey") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val leagueKey = backStackEntry.arguments?.getString("leagueKey") ?: ""
                val leagueName = backStackEntry.arguments?.getString("leagueName") ?: ""
                LeagueTabsScreen(leagueKey = leagueKey, leagueName = leagueName)
            }

        }
    }
}