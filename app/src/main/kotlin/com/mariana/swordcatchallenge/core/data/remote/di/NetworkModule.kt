package com.mariana.swordcatchallenge.core.data.remote.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton
import com.mariana.swordcatchallenge.BuildConfig
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
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .addNetworkInterceptor { chain ->
            val request = chain
                .request()
                .newBuilder()
                .addHeader("x-api-key", BuildConfig.API_KEY)
                .build()
            chain.proceed(request)
        }
        .build()
}
