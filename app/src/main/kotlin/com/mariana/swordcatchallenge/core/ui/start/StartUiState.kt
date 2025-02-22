package com.mariana.swordcatchallenge.core.ui.start

sealed class StartUiState {
    object Start : StartUiState()
    object Loading : StartUiState()
    object Loaded : StartUiState()
    object NoData : StartUiState()
}
