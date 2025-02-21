package com.mariana.swordcatchallenge.core.ui.start

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.mariana.swordcatchallenge.core.features.StartViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.mariana.swordcatchallenge.R
import com.mariana.swordcatchallenge.core.ui.components.CatList
import com.mariana.swordcatchallenge.core.ui.components.Header
import com.mariana.swordcatchallenge.core.ui.components.Loading
import kotlinx.coroutines.flow.Flow
import com.mariana.swordcatchallenge.core.ui.model.CatBreedUi

@Composable
fun StartScreen(
    viewModel: StartViewModel = hiltViewModel(),
) {

}

@Composable
fun StartContent(
    modifier: Modifier = Modifier,
    onEvent: (StartUiEvent) -> Unit,
    isLoading: Boolean,
    pagingData: Flow<PagingData<CatBreedUi>>,
) {
    val pagingData = pagingData.collectAsLazyPagingItems()

    Header(
        header = {
            Text(
                stringResource(R.string.start_point),
                style = MaterialTheme.typography.headlineSmall
            )
        },
        text = {
            when {
                !isLoading -> {
                    CatList(
                        modifier = modifier,
                        onCatBreedClick = { onEvent(StartUiEvent.OnCatBreedClick(it)) },
                        onFavoriteChanged = { catBreed, isFavorite ->
                            onEvent(StartUiEvent.OnFavoriteBreed(catBreed, isFavorite))
                        },
                        paging = pagingData
                    )
                }
                else -> Loading(modifier = Modifier.fillMaxSize())
            }
        }
    )
}
