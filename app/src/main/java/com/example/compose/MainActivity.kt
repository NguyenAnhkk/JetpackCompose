package com.example.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose.ui.theme.HomeScreen
import com.example.compose.ui.theme.LastScreen
import com.example.compose.ui.theme.SecondScreen
import com.example.compose.ui.theme.EndScreen
import com.example.compose.ui.theme.settingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //chia màn hình theo kích thước phù hợp
            val windowInfo = rememberWindowInfo()
            if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact){}
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(Screen.Home.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(
                            Screen.Second.route + "/{url}/{counter}",
                            arguments = listOf(
                                navArgument("url") { type = NavType.StringType },
                                navArgument("counter") { type = NavType.IntType },
                            )
                        ) { backStackEntry ->

                            SecondScreen(
                                navController = navController
                            )
                        }
                        composable(Screen.settings.route){
                            settingsScreen(navController = navController)
                        }

                        composable(Screen.Last.route) {
                            LastScreen(navController = navController)
                        }
                        composable(Screen.End.route){
                            EndScreen(navController = navController)
                        }

                    }
                }
            }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

//@Composable
//fun HomeScreen(navController: NavHostController) {
//
//}

@Composable
fun MultipleStyle() {
    Text(text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontSize = 30.sp,
                fontWeight = FontWeight(200),
                fontFamily = FontFamily.Cursive
            )
        ) {
            append("A")
        }
        append("nh")
        withStyle(
            style = SpanStyle(
                color = Color.Red,
                fontSize = 30.sp,
                fontWeight = FontWeight(200),
                fontFamily = FontFamily.Cursive
            )
        ) {
            append(" N")
        }
        append("guyen")
    })
}


@Composable
fun IconVector() {
    Image(imageVector = Icons.Filled.Person, contentDescription = null)
}

@Composable
fun SimpleButton() {
    val count = remember {
        mutableStateOf(0)
    }
    Column {
        Text(text = "Click count ${count.value}")
        Button(
            onClick = { count.value++ }, colors = ButtonDefaults.buttonColors(
                Color.LightGray
            )
        ) {
            Column {
                Image(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
                Text("Shopping cart")

            }

        }
    }

}

@Composable
fun RoundedCornerButton() {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)
    ) {
        Text(text = "Rounded Button")
    }
}

@Composable
fun BorderSimpleButton() {
    Button(
        onClick = { /*TODO*/ },
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        colors = ButtonDefaults.buttonColors(
            Color.White
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(text = "Border Button", color = Color.Magenta)

    }
}

@Composable
fun ElevationSimpleButtom() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color.White),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp, pressedElevation = 15.dp, disabledElevation = 0.dp
        )
    ) {
        Text(text = "Elevation Button", color = Color.Blue)
    }
}

@Composable
fun DisableSimpleButton() {
    Button(
        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            Color.Blue, disabledContentColor = Color.Red
        ), enabled = false
    ) {
        Text(text = "Disable Button")
    }

}

@Composable
fun DemoTap() {
    val number = remember {
        mutableStateOf("")
    }
    Column {
        Text(text = number.value)
        Text(text = "Something", modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(onDoubleTap = {
                number.value = "Double Tap"
            }, onLongPress = {
                number.value = "Long Press"
            }, onPress = {
                number.value = "Press"
            }

            )


        })
    }
}

@Composable
fun CommonSpace() {
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun DemoRadioButton(title: String) {
    var isSelected by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .selectable(
                selected = isSelected,
                onClick = { isSelected = !isSelected },
                role = Role.RadioButton
            )
            .padding(16.dp)
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Cyan,
                unselectedColor = Color.Green,
                disabledSelectedColor = Color.Gray,
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title)

    }
}

@Composable
fun DemoCustomRadioButton(title: String) {
    var isSelected by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .selectable(
                selected = isSelected,
                onClick = { isSelected = !isSelected },
                role = Role.RadioButton
            )
            .padding(16.dp)
    ) {
        var iconRadio = if (isSelected) Icons.Default.CheckCircle else Icons.Default.Check
        Image(iconRadio, contentDescription = null)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoOutlineTextFiled() {
    var email by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = email,
        onValueChange = { newValue -> email = newValue },
        placeholder = {
            Text(
                text = "username/email"
            )
        },
        label = { Text(text = "username/email") },
        leadingIcon = { Image(Icons.Default.Person, contentDescription = null) },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        )

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoOutlineTextFiled1() {
    var email by remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = email,
        onValueChange = { newValue -> email = newValue },
        placeholder = {
            Text(
                text = "password"
            )
        },
        label = { Text(text = "password") },
        leadingIcon = {
            IconButton(onClick = { showPassword = !showPassword }) {
                Image(
                    if (showPassword) Icons.Filled.Check else Icons.Filled.Close,
                    contentDescription = null
                )
            }

        },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Send
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun DemoTextField() {
    var firstName by remember {
        mutableStateOf("")
    }
    var keyBoard = LocalSoftwareKeyboardController.current
    TextField(
        value = firstName, onValueChange = { newValue ->
            firstName = newValue
        },
        textStyle = TextStyle(
            color = Color.Red, fontSize = 14.sp
        ),
        label = { (Text(text = "First Name")) },
        placeholder = { (Text(text = "Enter your name")) },
        leadingIcon = {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = "firstName"
            )
        },
        trailingIcon = {
            Image(Icons.Default.Close, contentDescription = "Info")
            IconButton(onClick = { firstName = "" }) {

            }
        },
        shape = RoundedCornerShape(20.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
            keyboardType = KeyboardType.Email,
            capitalization = KeyboardCapitalization.Words,
        ),
        keyboardActions = KeyboardActions( /* ẩn hiện bàn phím khi xử lí */
            onSearch = {
                keyBoard?.hide()
            }
        )
    )
}

@Composable
fun DemoBox() {
    Box() {
        Column(
            modifier = Modifier
                .background(color = Color.Black)
                .verticalScroll(rememberScrollState())
        ) {
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Magenta)
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Magenta)
            BoxItem(color = Color.White)
            BoxItem(color = Color.Cyan)
        }

    }
}

@Composable
fun BoxItem(modifier: Modifier = Modifier, color: Color, size: Dp = 100.dp) {
    Box(
        modifier = Modifier
            .size(size)
            .background(color = color)
    )
}

@Composable
fun VerticalList() {
    LazyColumn() {
        items(10) { index ->
            Text(text = "Nguyen Anh $index")
        }
    }
}

@Composable
fun HorizontalList() {
    LazyRow {
        items(10) { index ->
            Text(
                text = "Item $index",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun LazyVerticalGridDemo() {
    val list = (1..10).map { it.toString() }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),


        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(list.size) { index ->
                Box(
                    modifier = Modifier.background(Color.Magenta, shape = CircleShape)

                ) {
                    Text(
                        text = list[index],
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StateDemo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Log.e("Anh", "Login screen start")
        Welcom()
        var email by remember {
            mutableStateOf("")
        }
        OutlinedTextField(value = email, onValueChange = { newvalue -> email = newvalue })
        Log.e("Anh", "Login screen end")
    }
}

@Composable
fun Welcom() {
    Log.e("Anh", "Wellcom start")
    Text(text = "Login to your account")
    Log.e("Anh", "Wellcom end")
}

//@Composable
//fun Navigation() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
//        composable(route = Screen.MainScreen.route) {
//
//            MainScreen(navController = navController)
//        }
//        composable(
//            route = Screen.DentalScreen.route + "/{name}",
//            arguments = listOf(navArgument("name") {
//                type = NavType.StringType
//                defaultValue = "NguyenAnh"
//                nullable = true
//            })
//        ) { entry ->
//            DentalScreen(name = entry.arguments?.getString("name"))
//        }
//        composable(route = Screen.TTScreen.route) {
//            TTScreen()
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainScreen(navController: NavController) {
//    var text by remember {
//        mutableStateOf("")
//    }
//    Column(
//        verticalArrangement = Arrangement.Center, modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 50.dp)
//    ) {
//        TextField(value = text, onValueChange = { text = it }, modifier = Modifier.fillMaxWidth())
//        Spacer(modifier = Modifier.height(8.dp))
//        Button(onClick = {
//            navController.navigate(Screen.DentalScreen.withArgs(text))
//        }, modifier = Modifier.align(Alignment.End)) {
//            Text(text = "To DentalScreen")
//        }
//    }
//}
//
//@Composable
//fun DentalScreen(name: String?) {
//    val navController = rememberNavController()
//    Box(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentAlignment = Alignment.Center
//
//    ) {
//        Text(text = "Hello , $name")
//    }
//    Button(onClick = {
//        navController.navigate(Screen.TTScreen.route)
//    }) {
//        Text(text = "Đến màn hình TTScreen")
//    }
//}
//@Composable
//fun TTScreen() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = "This is TTScreen")
//    }
//}
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeTheme {
//        Row {
//            Text(text = "Anh")
//            Text(text = "Nguyen")
//        }
//    }
//}