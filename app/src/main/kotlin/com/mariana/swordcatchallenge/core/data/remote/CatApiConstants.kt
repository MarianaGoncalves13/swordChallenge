package com.mariana.swordcatchallenge.core.data.remote

import com.mariana.swordcatchallenge.BuildConfig

object CatApiConstants {
    const val BASE_URL = "https://api.thecatapi.com/v1/"
    const val API_TOKEN = BuildConfig.API_KEY
    const val BREEDS_URL = "breeds"
    const val BREEDS_ID_URL = "${BREEDS_URL}/{breed_id}"
    const val BREEDS_SEARCH_URL = "${BREEDS_URL}/search"
}