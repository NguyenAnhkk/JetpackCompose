package com.example.compose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.Screen

/**
 * @author Android Devs Academy (Ahmed Guedmioui)
 */
@Composable
fun MultipleStyle() {
    val textColor = MaterialTheme.colorScheme.background
    Column(
        modifier = Modifier.fillMaxWidth() .background(textColor),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF7df0c9),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("W")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFFc1f587),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("O")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFFff8605),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("R")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFFf252fa),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("D")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFFfa0f0f),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("B")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF51f5b9),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("E")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF5f51f5),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("N")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF7d00e3),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("D")
                }
            },
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF00d0ff),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("Q")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFFef3bf5),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("U")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFFf58f3b),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("E")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF1c3eff),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("S")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF22f028),
                        fontSize = 50.sp,
                        fontWeight = FontWeight(800),
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("T")
                }
            },
        )
    }
}

@Composable
fun ToggleThemeButton(
    isDarkTheme: Boolean,
    onToggleTheme: (Boolean) -> Unit
) {
    val textColor = MaterialTheme.colorScheme.background
    Row( modifier = Modifier.fillMaxWidth() . background(textColor)){

        Button(
            onClick = { onToggleTheme(!isDarkTheme) },
            modifier = Modifier.padding(30.dp).fillMaxWidth()
        ) {
            Text(text = if (isDarkTheme) "Switch to Light Theme" else "Switch to Dark Theme")
        }
    }


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    navController: NavHostController,
) {

    var isDarkTheme by remember { mutableStateOf(false) }
    ComposeTheme(
        darkTheme = isDarkTheme,
        onToggleTheme = {
            isDarkTheme = !isDarkTheme
        }
    ){
    Column{

        MultipleStyle()
        ToggleThemeButton(
            isDarkTheme = isDarkTheme,
            onToggleTheme = { isDarkTheme = it }

        )
        data class BottomNavigationItem(
            val title: String,
            val selectedIcon: ImageVector,
            val unselectedIcon: ImageVector,
            val hasNews: Boolean,
            val badgeCount: Int? = null,
        )
        val items = listOf(
            BottomNavigationItem(
                title = "Home",
                selectedIcon = Icons.Default.Home,
                unselectedIcon = Icons.Outlined.Home,
                hasNews = false,
            ),
            BottomNavigationItem(
                title = "user",
                selectedIcon = Icons.Default.AccountCircle,
                unselectedIcon = Icons.Outlined.AccountCircle,
                hasNews = false,
                badgeCount = 45,
            ),
            BottomNavigationItem(
                title = "Home",
                selectedIcon = Icons.Default.Settings,
                unselectedIcon = Icons.Outlined.Settings,
                hasNews = true,
            )
        )
        var selectedItemIndex by remember {
            mutableStateOf(0)
        }
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Scaffold(bottomBar = {
                NavigationBar {
                    items.forEachIndexed { index, items ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(Screen.settings.route)
                            },
                            label = {
                                    Text(text = items.title)
                            },
                            alwaysShowLabel = false,
                            icon = {
                                BadgedBox(badge = {
                                        if(items.badgeCount != null){
                                            Badge {
                                                Text(text = items.badgeCount.toString())
                                            }
                                        }
                                    else if(items.hasNews){
                                        Badge (

                                        )
                                    }
                                }

                                ) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            items.selectedIcon
                                        } else items.unselectedIcon,
                                        contentDescription = items.title
                                    )
                                }
                            })


                    }
                }
            }) {

            }
        }
    }
    }
}
