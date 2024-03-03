package com.example.myapplication

import androidx.compose.runtime.Composable
import java.io.File
import java.io.FileNotFoundException

class OnboardScreensLogic {
    private val fileName = "onboardInformation"

    @Composable
    fun choosingScreen(): Int {
        return gettingPassedOnboards()
    }

    private fun gettingPassedOnboards(): Int {
        var passed: Int
        try {
            File(fileName).bufferedReader().readLine().also {
                passed = it.toInt()
            }
        } catch (exception: FileNotFoundException) {
            passed = 0
        }
        return passed
    }
}