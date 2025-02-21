package com.mariana.swordcatchallenge.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

@Composable
fun Card(
    modifier: Modifier = Modifier,
    breed: String,
    image: String?,
    onClick: () -> Unit,
    isFavorite: Boolean,
    favoriteChanged: (Boolean) -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick,
    ) {
        CatCardRow(
           modifier = Modifier,
            breed = breed,
            isFavorite = isFavorite,
            favoriteChanged = favoriteChanged

        )
        //TODO Implement image after
    }
}

@Composable
fun CatCardRow(
    modifier: Modifier = Modifier,
    breed: String,
    isFavorite: Boolean,
    favoriteChanged: (Boolean) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CatFavoriteButton(
                isFavorite = isFavorite,
                favoriteChanged = favoriteChanged,
            )
            Text(
                modifier = Modifier
                    .padding(14.dp)
                    .weight(1F),
                text = breed,
                fontSize = 12.sp,
                maxLines = 1
            )
        }
    }
}
