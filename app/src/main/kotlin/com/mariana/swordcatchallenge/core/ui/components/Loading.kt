package com.mariana.swordcatchallenge.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.mariana.swordcatchallenge.core.ui.theme.SwordCatChallengeTheme

@Composable
fun Loading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
private fun LoadingPreview(){
    SwordCatChallengeTheme {
        Loading(Modifier.fillMaxSize())
    }
}
