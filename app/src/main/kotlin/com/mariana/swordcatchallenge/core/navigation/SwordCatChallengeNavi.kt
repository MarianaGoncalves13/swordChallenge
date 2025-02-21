package com.mariana.swordcatchallenge.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mariana.swordcatchallenge.core.ui.favorite.FavoriteScreen
import com.mariana.swordcatchallenge.core.ui.start.StartScreen


@Composable
fun SwordCatChallengeNavi(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier,
        bottomBar = {
            val current by navController.currentBackStackEntryAsState()
            NavBarNavigation(
                currentDestination = current?.destination,
                onBottomItemClick = navController::navigateToNextDestination
            )

        }){ padding ->
        NavHost(
            modifier = modifier.padding(padding),
            navController = navController,
            startDestination =   Destinations.Start,
        )            {
            composable<Destinations.Start>{
                StartScreen()
            }
            composable<Destinations.Favorite> {
                FavoriteScreen()
            }
        }
    }
}