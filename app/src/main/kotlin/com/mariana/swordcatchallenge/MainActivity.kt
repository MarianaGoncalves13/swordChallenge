package com.mariana.swordcatchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mariana.swordcatchallenge.core.navigation.SwordCatChallengeNavi
import dagger.hilt.android.AndroidEntryPoint
import com.mariana.swordcatchallenge.core.ui.theme.SwordCatChallengeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwordCatChallengeTheme {
                SwordCatChallengeNavi()
            }
        }
    }
}