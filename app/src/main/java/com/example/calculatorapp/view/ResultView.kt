package com.example.calculatorapp.view

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculatorapp.viewmodel.ViewModel
import com.example.calculatorapp.R

@ExperimentalAnimationApi
@SuppressLint("UnrememberedMutableState")
@Composable
fun ResultView(
    viewModel: ViewModel = hiltViewModel()
){
    val outPutText = viewModel.outPutText
    val equationText = viewModel.equationText
    val toggleEquationAnimation = viewModel.toggleEquationAnimation
    val toggleOutPutTestAnimation = viewModel.toggleOutPutTestAnimation

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        Column(horizontalAlignment = Alignment.End){
            AnimatedVisibility(
                visible = toggleEquationAnimation,
                enter = slideInHorizontally(
                    initialOffsetX = {-40},
                    animationSpec = spring(Spring.DampingRatioMediumBouncy)
                ),
                exit = slideOutHorizontally(targetOffsetX = {1000},tween(500))
            ) {
                Text(
                    text = equationText,
                    style = TextStyle(
                        fontSize = 50.sp,
                        color = colorResource(id = R.color.sideBtnColors)),
                    maxLines = 1,
                    overflow = TextOverflow.Clip,
                    softWrap = false,
                )
            }
            AnimatedVisibility(
                visible = toggleOutPutTestAnimation,
                enter = EnterTransition.None,
                exit = slideOutHorizontally(targetOffsetX = {1000},tween(500))
            ) {
                AnimatedContent(
                    targetState = outPutText,
                    transitionSpec = {
                        ContentTransform(
                            targetContentEnter = slideInHorizontally(
                                initialOffsetX = {-40},
                                animationSpec = spring(Spring.DampingRatioMediumBouncy)),
                            initialContentExit = ExitTransition.None,
                        )
                    }
                ) {
                    Text(
                        text = outPutText,
                        style = TextStyle(
                            fontSize = 80.sp,
                            color = Color.White),
                        maxLines = 1,
                        overflow = TextOverflow.Clip,
                        softWrap = false
                    )
                }
            }
        }
    }
}