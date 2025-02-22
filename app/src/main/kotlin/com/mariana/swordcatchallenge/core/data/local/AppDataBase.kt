package com.mariana.swordcatchallenge.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mariana.swordcatchallenge.core.data.local.dao.CatBreedDao
import com.mariana.swordcatchallenge.core.data.model.CatBreed

@Database(entities = [CatBreed::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    companion object {
        internal const val DATABASE_NAME = "sword_challenge_db"
    }
    abstract val catBreedDao: CatBreedDao
}
