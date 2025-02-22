package com.mariana.swordcatchallenge.core.data.remote.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mariana.swordcatchallenge.core.data.model.CatBreed
import com.mariana.swordcatchallenge.core.data.repository.CatBreedRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatBreedDataSource @Inject constructor(
    private val catBreedRepository: CatBreedRepository,
) : PagingSource<Int, CatBreed>() {
    override fun getRefreshKey(state: PagingState<Int, CatBreed>): Int? {
        return state.anchorPosition?.let { position ->
            val pageIndex = state.pages.indexOf(state.closestPageToPosition(position))
            state.pages.getOrNull(pageIndex + 1)?.prevKey
                ?: state.pages.getOrNull(pageIndex - 1)?.nextKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatBreed> {
        return try {
            val next = params.key ?: 0
            val catBreedResponse = catBreedRepository.getCatBreeds(next)

            LoadResult.Page(
                data = catBreedResponse,
                nextKey = next + 1,
                prevKey = if (next == 1) null else next - 1,
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}
