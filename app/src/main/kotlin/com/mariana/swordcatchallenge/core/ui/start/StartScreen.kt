package com.mariana.swordcatchallenge.core.ui.start

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.mariana.swordcatchallenge.core.ui.viewmodel.StartViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.mariana.swordcatchallenge.core.data.model.CatBreed
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.LazyPagingItems
import com.mariana.swordcatchallenge.R
import com.mariana.swordcatchallenge.core.ui.components.CatList
import com.mariana.swordcatchallenge.core.ui.components.Header
import com.mariana.swordcatchallenge.core.ui.components.Loading
import com.mariana.swordcatchallenge.core.ui.model.CatBreedUi

@Composable
@ExperimentalFoundationApi
fun StartScreen(
    viewModel: StartViewModel = hiltViewModel(),
) {
    val uiState: StartUiState by viewModel.uiState.observeAsState(StartUiState.Start)
    val catList: List<CatBreed> by viewModel.uiCatBreedList.observeAsState(emptyList())

    StartContent(
        modifier = Modifier
            .fillMaxSize(),
        onEvent = { event ->
            when (event) {
                is StartUiEvent.OnCatBreedClick -> TODO()
                is StartUiEvent.OnFavoriteBreed -> TODO()
                is StartUiEvent.OnSearchBreed -> TODO()
            }
        }
    )
}

@Composable
fun StartContent(
    modifier: Modifier = Modifier,
    onEvent: (StartUiEvent) -> Unit,
) {
    Header(
        header = {
            Text(
                text = stringResource(R.string.start_point),
                style = MaterialTheme.typography.headlineMedium
            )
        },
        text = {
            CatList(
                    modifier = modifier,
                    onCatBreedClick = {},
                    onFavoriteChanged = {catBreed , isFavorite ->
                        onEvent(StartUiEvent.OnFavoriteBreed(catBreed, isFavorite))
                    },
                )
         }
        }
    )
}
