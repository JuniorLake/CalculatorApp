package com.example.calculatorapp.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.R

@ExperimentalAnimationApi
@Composable
fun Calculator(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.primary_color))
    ) {

        ResultView()

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .align(Alignment.BottomStart),
            elevation = 10.dp,
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp
            ),
            backgroundColor = colorResource(id = R.color.secondary_color),
        ) {
            ButtonGrid()
        }
    }
}