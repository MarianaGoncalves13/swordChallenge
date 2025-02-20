package com.mariana.swordcatchallenge.core.data.local.di

import android.content.Context
import androidx.room.Room
import com.mariana.swordcatchallenge.core.data.local.dao.BreedDao
import com.mariana.swordcatchallenge.core.data.local.SwordChallengeDataBase
import com.mariana.swordcatchallenge.core.data.local.SwordChallengeDataBase.Companion.DATABASE_NAME
import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    fun provideBreedDao(
        database: SwordChallengeDataBase
    ): BreedDao = database.getBreedDao()

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): SwordChallengeDataBase = Room.databaseBuilder(
        context,
        SwordChallengeDataBase::class.java,
        DATABASE_NAME
    ).build()
}
