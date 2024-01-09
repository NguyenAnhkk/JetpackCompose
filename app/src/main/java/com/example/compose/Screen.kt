package com.example.compose

sealed class Screen(var route : String){

    object Home : Screen("home")
    object Second : Screen("second")
    object settings : Screen("settings")
    object Last : Screen("last")
    object End : Screen("end")
}
