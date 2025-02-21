package com.mariana.swordcatchallenge.core.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    header: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier,
    text: @Composable ColumnScope.() -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                windowInsets = WindowInsets(top = 0.dp, bottom = 0.dp, right = 20.dp, left = 0.dp),
                title = {
                    Column (
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                            .fillMaxSize(),
                        content = header,
                    )
                },
                scrollBehavior = scrollBehavior,
            )
        }
    ) { padding ->
        Column (
            content = text,
            modifier = Modifier.padding(padding)
        )
    }
}
