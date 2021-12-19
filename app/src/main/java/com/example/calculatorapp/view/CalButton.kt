package com.example.calculatorapp.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculatorapp.R
import com.example.calculatorapp.viewmodel.ViewModel

@Composable
fun CalButton(
    modifier: Modifier = Modifier,
    btnText: String,
    textColor: Color = Color.White,
    textSize: Int? = 19,
    viewModel: ViewModel = hiltViewModel()
){
    Button(
        onClick = {
            viewModel.buttonType(btnText)
        },
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.primary_color)),
        elevation = ButtonDefaults.elevation(5.dp),
        modifier = modifier
            .size(63.dp),
        contentPadding = PaddingValues(0.dp)

    ) {
        if (btnText != "null") {
            Text(
                btnText,
                color = textColor,
                fontSize = textSize!!.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
        } else{
            Icon(painter = painterResource(
                id = R.drawable.ic_baseline_refresh_24),
                contentDescription = " ",
                tint = Color.White
            )
        }
    }
}