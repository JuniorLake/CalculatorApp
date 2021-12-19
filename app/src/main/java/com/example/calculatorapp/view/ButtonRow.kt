package com.example.calculatorapp.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonRow(
    text1: String, textColor1: Color,
    text2: String, textColor2: Color,
    text3: String, textColor3: Color,
    text4: String, textColor4: Color,
){
    @Composable
    fun GridSpacer() { Spacer(modifier = Modifier.padding(9.dp)) }

    Row(modifier = Modifier
        .padding(horizontal = 10.dp ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CalButton(btnText = text1, textColor = textColor1)
        GridSpacer()
        CalButton(btnText = text2, textColor = textColor2)
        GridSpacer()
        CalButton(btnText = text3, textColor = textColor3)
        GridSpacer()
        CalButton(btnText = text4, textColor = textColor4)
    }
}
