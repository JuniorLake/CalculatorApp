package com.example.calculatorapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.R

@Composable
fun ButtonGrid(
) {
    @Composable
    fun GridSpacer() { Spacer(modifier = Modifier.padding(9.dp)) }

    Column(
        modifier = Modifier.padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val topBtnColors = colorResource(id = R.color.topBtnColors)
        val sideBtnColors = colorResource(id = R.color.sideBtnColors)
        ButtonRow("AC",topBtnColors,"DEL",topBtnColors,"Ans",topBtnColors,"/",sideBtnColors)
        GridSpacer()
        ButtonRow("7", Color.White,"8", Color.White,"9", Color.White,"x",sideBtnColors)
        GridSpacer()
        ButtonRow("4", Color.White,"5", Color.White,"6", Color.White,"-",sideBtnColors)
        GridSpacer()
        ButtonRow("1", Color.White,"2", Color.White,"3", Color.White,"+",sideBtnColors)
        GridSpacer()
        Row {
            CalButton(btnText = ".", textColor = Color.White)
            GridSpacer()
            CalButton(btnText = "0", textColor = Color.White)
            GridSpacer()
            CalButton(btnText = "=", textColor = Color.White, modifier = Modifier.height(63.dp).width(145.dp))
        }
    }
}