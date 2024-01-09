package com.example.compose.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import com.example.compose.Screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

/**
 * @author Android Devs Academy (Ahmed Guedmioui)
 */

@Composable
fun HomeScreen(navController: NavHostController) {
//    val shape: Shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    val brush = Brush.linearGradient(listOf(Color.Red, Color.Blue))
//    Canvas(
//        modifier = Modifier.size(200.dp),
//        onDraw = {
//            drawCircle(brush)
//        }
//    )
    Column(
        modifier = Modifier
            .background(brush)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Wordbend Quest",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight(800),


        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate(Screen.Second.route + "/www.url.com/44")

        } , modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(50.dp)) {
            Text(
                text = "Start",
                fontSize = 20.sp,
                fontWeight = FontWeight(600)

            )
        }
    }
}