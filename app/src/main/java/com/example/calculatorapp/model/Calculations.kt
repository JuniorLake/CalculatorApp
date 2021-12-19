package com.example.calculatorapp.model

class Calculations {
    fun onEqual(outPutText: String): String{
        var result = " "
        when {
            outPutText.contains("+") -> {
                val splitValue = outPutText.split("+")

                val partOne = splitValue[0]
                val partTwo = splitValue[1]

                result = (partOne.toDouble() + partTwo.toDouble()).toString()

            }
            outPutText.contains("x") -> {
                val splitValue = outPutText.split("x")

                val partOne = splitValue[0]
                val partTwo = splitValue[1]

                result = (partOne.toDouble() * partTwo.toDouble()).toString()
            }
            outPutText.contains("/") -> {
                val splitValue = outPutText.split("/")

                val partOne = splitValue[0]
                val partTwo = splitValue[1]

                result = (partOne.toDouble() / partTwo.toDouble()).toString()
            }
            outPutText.contains("-") -> {
                val splitValue = outPutText.split("-")

                val partOne = splitValue[0]
                val partTwo = splitValue[1]

                result = (partOne.toDouble() - partTwo.toDouble()).toString()
            }
            outPutText.contains("%") -> {
                outPutText.replace(oldValue = "%", newValue = "/100")

                val splitValue = outPutText.split("/")

                val partOne = splitValue[0]
                val partTwo = splitValue[1]

                result = (partOne.toDouble() / partTwo.toDouble()).toString()
            }
        }
        return result
    }
}