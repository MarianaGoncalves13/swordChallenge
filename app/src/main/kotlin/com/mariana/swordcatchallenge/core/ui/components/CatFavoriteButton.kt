package com.mariana.swordcatchallenge.core.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CatFavoriteButton(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    favoriteChanged: (Boolean) -> Unit,
) {
    IconButton(
        modifier = modifier,
        onClick = { favoriteChanged(!isFavorite) }
    ) {
        val colorForButton by animateColorAsState(
            targetValue = if(!isFavorite) Color.White else Color.DarkGray
        )
        Icon(
            imageVector = when {
                !isFavorite -> Icons.Outlined.FavoriteBorder
                else -> Icons.Filled.Favorite
            },
            tint = colorForButton,
            contentDescription = null,
        )
    }
}
