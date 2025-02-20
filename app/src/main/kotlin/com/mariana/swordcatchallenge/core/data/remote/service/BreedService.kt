package com.mariana.swordcatchallenge.core.data.remote.service

import com.mariana.swordcatchallenge.core.data.remote.model.CatBreedResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BreedService {

    @GET("/breeds")
    suspend fun getBreeds(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
    ): List<CatBreedResponse>

    @GET("/breeds/{id}")
    suspend fun getBreed(@Path("id") id: Int): CatBreedResponse
}