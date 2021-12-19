package com.example.calculatorapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculatorapp.model.Calculations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor() : ViewModel() {
    var outPutText by mutableStateOf(" ")
    var equationText by mutableStateOf(" ")
    var toggleEquationAnimation by mutableStateOf(false)
    var toggleOutPutTestAnimation by mutableStateOf(true)

    private var lastNumeric by mutableStateOf(false)
    private var lastDot by mutableStateOf(false)
    private var digitsAllowed by mutableStateOf(true)

    private fun isOperatorAdded(value: String): Boolean{
        return value.contains("/") || value.contains("x") ||
            value.contains("+") || value.contains("-")
    }

    private fun onOperator(btnText: String){
        if(lastNumeric && !isOperatorAdded(outPutText)){
            outPutText += btnText
            lastNumeric = false
            lastDot = false
        }
    }

    fun buttonType(btnText: String){
        when (btnText) {
            "/" -> onOperator(btnText)
            "x" -> onOperator(btnText)
            "-" -> onOperator(btnText)
            "+" -> onOperator(btnText)
            "=" -> {
                if (lastNumeric&&!toggleEquationAnimation){
                    equationText = outPutText+btnText
                    toggleEquationAnimation = true
                    lastNumeric = false
                    digitsAllowed = false
                    outPutText = Calculations().onEqual(outPutText)
                }
            }
            "AC" ->{
                toggleEquationAnimation = false
                toggleOutPutTestAnimation = false
                viewModelScope.launch {
                    delay(500)
                    outPutText = " "
                    toggleOutPutTestAnimation = true
                }
                lastNumeric = false
                lastDot = false
                digitsAllowed = true
            }
            "." ->{
                if (lastNumeric && !lastDot) {
                    outPutText += btnText
                    lastNumeric = false
                    lastDot = true
                }
            }
            "DEL" -> {
                if (lastNumeric){
                    outPutText = outPutText.dropLast(1)
                }
            }
            "Ans" ->{
                if(!digitsAllowed){
                    toggleEquationAnimation = false
                    toggleOutPutTestAnimation = false
                    viewModelScope.launch {
                        delay(500)
                        toggleOutPutTestAnimation = true
                    }
                    lastNumeric = true
                    lastDot = false
                    digitsAllowed = true
                }
            }
            "null" -> { }
            else -> {
                if(digitsAllowed) {
                    outPutText += btnText
                    lastNumeric = true
                }
            }
        }
    }
}