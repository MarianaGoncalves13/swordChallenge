package com.mariana.swordcatchallenge.core.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mariana.swordcatchallenge.core.data.model.CatBreed
import com.mariana.swordcatchallenge.core.data.remote.datasource.CatBreedDataSource
import com.mariana.swordcatchallenge.core.data.repository.CatBreedRepository
import com.mariana.swordcatchallenge.core.ui.start.StartUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val catBreedRepository: CatBreedRepository
) : ViewModel() {

    //Prepare to show the list with paging
    val catBreeds = Pager(PagingConfig(pageSize = 16)) {
        CatBreedDataSource(catBreedRepository)
    }.flow.cachedIn(viewModelScope)

    val showCatLists = mutableStateOf(false)

    private val _uiState = MutableLiveData<StartUiState>(StartUiState.Start)
    val uiState: LiveData<StartUiState>
        get() = _uiState

    private val _uiList = MutableLiveData<List<CatBreed>>()
    val uiCatBreedList: LiveData<List<CatBreed>>
        get() = _uiList

    //Prepare the search by breeds
    var searchQuery = mutableStateOf("")

    fun getBreedsBySearch(searchQuery: String) {
        viewModelScope.launch {
            _uiState.postValue(StartUiState.Loading)
            val response = catBreedRepository.getSearchBreed(searchQuery)
            _uiList.postValue(response)
            if (response.isNotEmpty()) {
                _uiState.postValue(StartUiState.Loaded)
            } else {
                _uiState.postValue(StartUiState.NoData)
            }
        }
    }
}
