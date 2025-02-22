package com.mariana.swordcatchallenge.core.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.mariana.swordcatchallenge.core.data.model.CatBreed

@Dao
interface CatBreedDao {

    @Query("SELECT * FROM cat_breeds")
    fun getAllBreedsPaged(): PagingSource<Int, CatBreed>

    @Upsert
    suspend fun upsert(breeds: List<CatBreed>)

    @Query("SELECT * from cat_breeds where id = :id")
    suspend fun findCatBreed(id: String): CatBreed?

    @Update
    suspend fun updateCatBreed(breed: CatBreed): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(catBreeds: List<CatBreed>)
}
