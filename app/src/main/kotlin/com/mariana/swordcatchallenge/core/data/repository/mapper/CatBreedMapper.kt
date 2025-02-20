package com.mariana.swordcatchallenge.core.data.repository.mapper

import com.mariana.swordcatchallenge.core.data.local.model.BreedEntity
import com.mariana.swordcatchallenge.core.data.remote.model.CatBreedResponse
import com.mariana.swordcatchallenge.core.model.repository.CatBreed

internal fun List<CatBreedResponse>.toEntity(): List<BreedEntity> = map(CatBreedResponse::toEntity)

internal fun List<BreedEntity>.toDomain(): List<CatBreed> = map(BreedEntity::toDomain)

internal fun CatBreedResponse.toEntity() = BreedEntity(
    id = id,
    name = name,
    origin = origin,
    temperament = temperament,
    description = description,
    imageUrl = imageId,
    favoriteId = favoriteId,
    lifeSpan = lifeSpan,
)

fun BreedEntity.toDomain() = CatBreed(
    id = id,
    name = name,
    origin = origin,
    temperament = temperament,
    description = description,
    imageUrl = imageUrl,
    lifeSpan = lifeSpan,
    isFavorite = favoriteId != null,
)
