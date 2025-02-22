package com.mariana.swordcatchallenge.core.ui.start

import com.mariana.swordcatchallenge.core.ui.model.CatBreedUi

sealed interface StartUiEvent {
    data class OnCatBreedClick(val catBreed: CatBreedUi) : StartUiEvent
    data class OnFavoriteBreed(val catBreed: CatBreedUi, val isFavorite: Boolean) : StartUiEvent
    data class OnSearchBreed(val breed: String) : StartUiEvent
}

