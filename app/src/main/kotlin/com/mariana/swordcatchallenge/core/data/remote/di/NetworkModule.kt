package com.mariana.swordcatchallenge.core.data.remote.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton
import com.mariana.swordcatchallenge.BuildConfig
import com.mariana.swordcatchallenge.core.data.remote.service.BreedService
import dagger.Provides

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit
        .Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()


    @Provides
    @Singleton
    fun provideAuthInterceptorOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(AuthInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideCatBreedApiService(retrofit: Retrofit): BreedService {
        return retrofit.create(BreedService::class.java)
    }
}
