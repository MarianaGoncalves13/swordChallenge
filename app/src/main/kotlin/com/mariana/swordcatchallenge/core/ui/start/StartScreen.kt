package com.mariana.swordcatchallenge.core.ui.start

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import com.mariana.swordcatchallenge.core.features.StartViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mariana.swordcatchallenge.core.ui.theme.SwordCatChallengeTheme

@Composable
fun StartScreen(
    viewModel: StartViewModel = hiltViewModel()) {

    StartContent(
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun StartContent(modifier: Modifier = Modifier) {
    //TODO will implement latter
}

@Preview
@Composable
private fun StartScreenPreview(){
    SwordCatChallengeTheme {
        StartContent()
    }
}
