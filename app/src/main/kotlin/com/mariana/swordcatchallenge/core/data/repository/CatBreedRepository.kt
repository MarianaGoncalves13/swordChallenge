package com.mariana.swordcatchallenge.core.data.repository

import com.mariana.swordcatchallenge.core.data.local.dao.CatBreedDao
import com.mariana.swordcatchallenge.core.data.model.CatBreed
import com.mariana.swordcatchallenge.core.data.remote.service.BreedService
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CatBreedRepository @Inject constructor (
    private val breedService: BreedService,
    private val catBreedDao: CatBreedDao
) {

    suspend fun getCatBreeds(page: Int): List<CatBreed> {
        try {

            val response = breedService.getBreeds(10, page)
            if(response.isSuccessful) {
                response.body()?.let {
                    catBreedDao.insertAll(it)
                    return it
                }
            }
        } catch (error: Error) {
            error.printStackTrace()
        }
        return emptyList()
    }
}


