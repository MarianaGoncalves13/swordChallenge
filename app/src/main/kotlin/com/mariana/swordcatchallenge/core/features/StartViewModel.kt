package com.mariana.swordcatchallenge.core.features

import androidx.lifecycle.ViewModel
import com.mariana.swordcatchallenge.core.data.repository.CatBreedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val catBreedRepository: CatBreedRepository
): ViewModel() {
}