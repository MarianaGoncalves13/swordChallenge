package com.mariana.swordcatchallenge.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.ui.graphics.vector.ImageVector
import com.mariana.swordcatchallenge.R

enum class NavBarDestination(
    @StringRes
    val labelRes: Int,
    val destination: Destinations,
    val iconVector: ImageVector,
) {
    Start(
        labelRes = R.string.start_point,
        destination = Destinations.Start,
        iconVector = Icons.Filled.Home,
    ),
    Favorite(
        labelRes = R.string.favorite_point,
        destination = Destinations.Favorite,
        iconVector = Icons.Outlined.Favorite,
    ),
}
