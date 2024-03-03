package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

class OnboardScreensUI2 {
    private val imagesList = mutableListOf(
        R.drawable.onboard0, R.drawable.onboard11,
        R.drawable.onboard12, R.drawable.onboard21, R.drawable.onboard22, R.drawable.onboard31,
        R.drawable.onboard32, R.drawable.holder
    )

    @Composable
    fun ShowingOnboard() {
        var queue = 0
        val passedOnboards = OnboardScreensLogic().choosingScreen()
        if (passedOnboards == 2) {
            queue = 3
        } else if (passedOnboards == 3) {
            queue = 5
        } else if (passedOnboards == 4) {
            queue = 7
        } else if (passedOnboards == 5) {
            queue = 8
        } else {
            queue = passedOnboards
        }
        DrawingOnboard(queue = queue)
    }

    @Composable
    fun DrawingOnboard(queue: Int) {
        var newQueue = queue
        if ((queue == 0) || (queue == 1)) {
            Image(painter = painterResource(imagesList[queue]),
                contentDescription = "",
                modifier = Modifier.clickable {
                    newQueue += 2
                })
        } else if (queue == 2) {
            Image(painter = painterResource(imagesList[queue]),
                contentDescription = "",
                modifier = Modifier.clickable {
                    newQueue++
                })
        } else if ((queue > 2) && (queue < 8)) {
            Image(painter = painterResource(imagesList[queue]),
                contentDescription = "",
                modifier = Modifier.clickable {
                    newQueue += 2
                })
        }
        if (newQueue < 8) {
            DrawingOnboard(queue = newQueue)
        }
    }
}