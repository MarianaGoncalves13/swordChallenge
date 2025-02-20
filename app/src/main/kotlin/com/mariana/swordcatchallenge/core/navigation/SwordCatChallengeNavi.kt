package com.mariana.swordcatchallenge.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun SwordCatChallengeNavi(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination =   Destinations.Start,
    )            {
        composable<Destinations.Start>{
            //TODO implement after
        }
    }
}