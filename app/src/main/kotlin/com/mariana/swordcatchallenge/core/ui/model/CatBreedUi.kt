package com.mariana.swordcatchallenge.core.ui.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class CatBreedUi(
    val id: String,
    val name: String,
    val origin: String,
    val temperament: String,
    val description: String,
    val imageUrl: String?,
    val isFavorite: Boolean,
    val lifeSpan: String
)