package com.mariana.swordcatchallenge.core.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.LoadState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mariana.swordcatchallenge.core.data.model.CatBreed



@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun CatGridView(
    lazyCatList: LazyPagingItems<CatBreed>,
    navController: NavController,
) {
    LazyVerticalGrid(
        modifier = Modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(14.dp)
    ) {
        items(lazyCatList) { catBreed ->
            catBreed?.let {
                 CatBreedGridItem(catBreed, navController)
            }

        }
        lazyCatList.apply {
            when (loadState.refresh) {
                is LoadState.Loading -> {
                    item { Loading(modifier = Modifier.fillMaxSize()) }
                }

                is LoadState.Error -> {
                    val error = lazyCatList.loadState.refresh as LoadState.Error
                    item { Text(error.error.localizedMessage!!) }
                }

                is LoadState.NotLoading -> TODO()
            }
        }
    }
}

@ExperimentalFoundationApi
fun <T: Any> LazyGridScope.items(
    lazyPagingItems: LazyPagingItems<T>,
    itemContent: @Composable LazyItemScope.(value: T?) -> Unit
) {
    items(lazyPagingItems.itemCount) { index ->
        itemContent(lazyPagingItems[index])
    }
}
