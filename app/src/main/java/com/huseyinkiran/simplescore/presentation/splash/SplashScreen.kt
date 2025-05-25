package com.huseyinkiran.simplescore.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.huseyinkiran.simplescore.R
import com.huseyinkiran.simplescore.presentation.navigation.Screen

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {

    val navigateToLeagueList by viewModel.navigateToLeagueList

    LaunchedEffect(navigateToLeagueList) {
        if (navigateToLeagueList) {
            navController.navigate(Screen.LeagueList.route) {
                popUpTo(Screen.SplashScreen.route) { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.app_bar_color))
    ) {
        Image(
            painterResource(R.drawable.simplescore_icon),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )
    }
}