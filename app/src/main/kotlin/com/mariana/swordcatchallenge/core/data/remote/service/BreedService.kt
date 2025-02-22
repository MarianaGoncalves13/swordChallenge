package com.mariana.swordcatchallenge.core.data.remote.service

import com.mariana.swordcatchallenge.core.data.model.CatBreed
import com.mariana.swordcatchallenge.core.data.remote.CatApiConstants.BREEDS_SEARCH_URL
import com.mariana.swordcatchallenge.core.data.remote.CatApiConstants.BREEDS_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BreedService {

    @GET(BREEDS_URL)
    suspend fun getBreeds(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
    ): Response<List<CatBreed>>

    @GET(BREEDS_SEARCH_URL)
    suspend fun getSearchBreed(@Query("q") searchQuery: String): Response<List<CatBreed>>
}