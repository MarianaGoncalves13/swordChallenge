package com.mariana.swordcatchallenge.core.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mariana.swordcatchallenge.core.data.remote.datasource.CatBreedDataSource
import com.mariana.swordcatchallenge.core.data.repository.CatBreedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val catBreedRepository: CatBreedRepository
) : ViewModel() {
    val catBreeds = Pager(PagingConfig(pageSize = 16)) {
        CatBreedDataSource(catBreedRepository)
    }.flow.cachedIn(viewModelScope)
}
