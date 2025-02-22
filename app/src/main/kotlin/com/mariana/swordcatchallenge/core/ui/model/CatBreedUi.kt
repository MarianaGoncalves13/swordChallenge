package com.mariana.swordcatchallenge.core.ui.model

import androidx.compose.runtime.Immutable

@Immutable
data class CatBreedUi(
    val id: String,
    val name: String,
    val temperament: String,
    val origin: String,
    val description: String,
    val imageUrl: String?,
    val isFavorite: Boolean,
    val lifeSpan: String
)