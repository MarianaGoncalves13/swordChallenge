package com.mariana.swordcatchallenge.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.mariana.swordcatchallenge.core.ui.model.CatBreedUi
import androidx.compose.ui.unit.dp
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey

@Composable
internal fun CatList(
    modifier: Modifier = Modifier,
    onCatBreedClick: (CatBreedUi) -> Unit,
    onFavoriteChanged: (CatBreedUi, Boolean) -> Unit,
    paging: LazyPagingItems<CatBreedUi>
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(14.dp)
    ) {
        items(
            contentType = paging.itemContentType{"CatList"},
            count = paging.itemCount,
            key = paging.itemKey{it.id},
        ) { indicator ->
            val item = paging[indicator] ?: return@items
            Card(
                modifier = Modifier.animateItem(),
                breed = item.name,
                image = item.imageUrl,
                isFavorite = item.isFavorite,
                favoriteChanged = {onFavoriteChanged(item, it)},
                onClick = {onCatBreedClick(item)}
            )
        }
    }
}
