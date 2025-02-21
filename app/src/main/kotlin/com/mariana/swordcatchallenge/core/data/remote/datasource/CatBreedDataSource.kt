package com.mariana.swordcatchallenge.core.data.remote.datasource

import com.mariana.swordcatchallenge.core.data.remote.model.CatBreedResponse
import com.mariana.swordcatchallenge.core.data.remote.service.BreedService
import com.mariana.swordcatchallenge.core.data.repository.dispatcher.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatBreedDataSource @Inject constructor(
    private val breedService: BreedService,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) {
    fun getCatBreed(
        page: Int,
        limit: Int,
    ):Flow<List<CatBreedResponse>> = flow {
        emit(breedService.getBreeds(limit, page))
    }
}