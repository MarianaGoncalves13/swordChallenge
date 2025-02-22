package com.mariana.swordcatchallenge.core.data.local.di

import android.content.Context
import androidx.room.Room
import com.mariana.swordcatchallenge.core.data.local.dao.CatBreedDao
import com.mariana.swordcatchallenge.core.data.local.AppDataBase
import com.mariana.swordcatchallenge.core.data.local.AppDataBase.Companion.DATABASE_NAME
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
        database: AppDataBase
    ): CatBreedDao = database.catBreedDao

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDataBase = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        DATABASE_NAME
    ).build()
}
