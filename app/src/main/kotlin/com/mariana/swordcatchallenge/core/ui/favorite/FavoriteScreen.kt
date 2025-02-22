package com.mariana.swordcatchallenge.core.ui.favorite

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mariana.swordcatchallenge.core.ui.viewmodel.FavoriteViewModel
import com.mariana.swordcatchallenge.core.ui.theme.SwordCatChallengeTheme

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    FavoriteContent(
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun FavoriteContent(modifier: Modifier = Modifier) {
    //TODO Will be implemented latter
}

@Preview
@Composable
private fun FavoriteContentPreview() {
    SwordCatChallengeTheme {
        FavoriteContent()
    }
}
