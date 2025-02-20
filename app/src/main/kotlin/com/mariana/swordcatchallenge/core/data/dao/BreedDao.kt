package com.mariana.swordcatchallenge.core.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.mariana.swordcatchallenge.core.data.model.BreedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BreedDao {

    @Query("SELECT * FROM breeds")
    fun getBreedsPaging(): PagingSource<Int, BreedEntity>

    @Upsert
    suspend fun upsert(breeds: List<BreedEntity>)

    @Query("SELECT * from breeds where favorite_id is NOT null")
    fun getFavoritesBreed(): Flow<List<BreedEntity>>

    @Query("SELECT * from breeds where id = :id")
    suspend fun findBreed(id: String): BreedEntity?
}
