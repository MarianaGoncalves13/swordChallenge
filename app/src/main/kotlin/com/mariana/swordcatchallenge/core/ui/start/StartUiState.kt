package com.mariana.swordcatchallenge.core.ui.start

import androidx.compose.runtime.Immutable
import androidx.paging.PagingData
import com.mariana.swordcatchallenge.core.ui.model.CatBreedUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Immutable
data class StartUiState(
    val loading: Boolean = true,
    val search: String = "",
    val paging: Flow<PagingData<CatBreedUi>> = emptyFlow(),
)