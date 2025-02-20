package com.mariana.swordcatchallenge.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mariana.swordcatchallenge.core.data.dao.BreedDao
import com.mariana.swordcatchallenge.core.data.model.BreedEntity

@Database(entities = [BreedEntity::class], version = 1)
abstract class SwordChallengeDataBase: RoomDatabase() {
    companion object {
        internal const val DATABASE_NAME = "sword_challenge_db"
    }
    abstract fun getBreedDao(): BreedDao
}
