package com.mariana.swordcatchallenge.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mariana.swordcatchallenge.core.data.model.CatBreed
import com.mariana.swordcatchallenge.core.ui.theme.Black

@Composable
fun CatBreedGridItem(catBreed: CatBreed, navController: NavController) {
    Card(
        shape = RoundedCornerShape(3.dp),
        border = BorderStroke(0.5.dp, Black),
        modifier = Modifier
            .padding(4.dp)
            .height(180.dp),
    ) {
        Column(modifier = Modifier.clickable(
            onClick = {
                navController.navigate("breed_details/${catBreed.id}")
            }
        )
        ) {
            catBreed.name.let {
                //TODO implement image after
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 8.dp)
                )
            }
        }
    }
}