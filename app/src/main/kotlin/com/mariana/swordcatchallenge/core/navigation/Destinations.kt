package com.mariana.swordcatchallenge.core.navigation

import kotlinx.serialization.Serializable

sealed interface Destinations {
    @Serializable
    data object Start: Destinations
}
