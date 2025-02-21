package com.mariana.swordcatchallenge.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

fun NavController.navigateToNextDestination(
    navBarDestination: NavBarDestination
) = navigate(navBarDestination) {
    popUpTo(graph.findStartDestination()) {
        saveState = true
    }
    restoreState = true
    launchSingleTop = true
}