package com.mariana.swordcatchallenge.core.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import com.mariana.swordcatchallenge.core.ui.theme.SwordCatChallengeTheme

@Composable
private fun RowScope.NavigationItem(
    navBarItem: NavBarDestination,
    isActive: Boolean,
    onBottomItemClick: (NavBarDestination) -> Unit
) {
    NavigationBarItem(
        icon = {
            Icon(
                contentDescription = stringResource(navBarItem.labelRes),
                imageVector = navBarItem.iconVector
            )
        },
        selected = isActive,
        onClick = { onBottomItemClick(navBarItem) }
    )
}

@Composable
fun NavBarNavigation(
    modifier: Modifier = Modifier,
    onBottomItemClick: (NavBarDestination) -> Unit,
    currentDestination: NavDestination?
) {
    NavigationBar(modifier = modifier) {
        val navBarDestinations = remember { NavBarDestination.entries }
        navBarDestinations.forEach { navBarItem ->
            val isActive = remember(currentDestination) {
                currentDestination?.hierarchy?.any {
                    it.hasRoute(navBarItem.destination::class)
                } == true
            }
            NavigationItem(
                navBarItem = navBarItem,
                isActive = isActive,
                onBottomItemClick = onBottomItemClick
            )
        }
    }
}
