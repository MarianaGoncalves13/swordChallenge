package com.mariana.swordcatchallenge.core.data.remote.service.di

import com.mariana.swordcatchallenge.core.data.remote.service.BreedService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideBreedService(retrofit: Retrofit) = retrofit.create(BreedService::class.java)
}
