package com.example.compose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.Screen
import com.example.compose.rememberImeState
import java.time.format.TextStyle

/**
 * @author Android Devs Academy (Ahmed Guedmioui)
 */

@Composable
fun LastScreen(navController: NavHostController) {
    Column(
        Modifier.fillMaxSize()
    ) {
        Button(onClick = {
            navController.popBackStack()
        }) {

            Image(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
        }
        Button(onClick = { navController.navigate(Screen.End.route) }) {
            Text(text = "EndScreen next")
        }
        ConvertImage()
        OtpScreen()


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen() {
    val (inputText, setInputText) = remember { mutableStateOf("") }
    var showImages2To4 by remember { mutableStateOf(false) }
    var isInputCorrect by remember { mutableStateOf(true) }

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()
    LaunchedEffect(key1 = imeState) {
        scrollState.scrollTo(scrollState.maxValue)
    }
    fun checkInput() {
        if (inputText.equals("BASE", ignoreCase = true)) {
            showImages2To4 = true
            isInputCorrect = true
        } else {
            isInputCorrect = false
        }
    }

    val focusManager = LocalFocusManager.current
    val (digit1, setDigit1) = remember {
        mutableStateOf("")
    }
    val (digit2, setDigit2) = remember {
        mutableStateOf("")
    }
    val (digit3, setDigit3) = remember {
        mutableStateOf("")
    }
    val (digit4, setDigit4) = remember {
        mutableStateOf("")
    }
    fun onValueChangeLimited(newValue: String, setValue: (String) -> Unit) {
        if (newValue.length <= 1) {
            setValue(newValue)
        }
    }

    fun clearAll() {
        setDigit1("")
        setDigit2("")
        setDigit3("")
        setDigit4("")
    }
    LaunchedEffect(
        key1 = digit1,
    ) {
        if (digit1.isNotEmpty()) {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next,
            )
        }
    }
    LaunchedEffect(
        key1 = digit2,
    ) {
        if (digit2.isNotEmpty()) {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next,
            )
        }
    }
    LaunchedEffect(
        key1 = digit3,
    ) {
        if (digit3.isNotEmpty()) {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next,
            )
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        OutlinedTextField(
            value = digit1,
            onValueChange = { onValueChangeLimited(it, setDigit1) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Sentences
            ),
            modifier = Modifier.width(64.dp),
        )
        OutlinedTextField(
            value = digit2,
            onValueChange = { onValueChangeLimited(it, setDigit2) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Sentences
            ),
            modifier = Modifier.width(64.dp),
        )
        OutlinedTextField(
            value = digit3,
            onValueChange = { onValueChangeLimited(it, setDigit3) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Sentences
            ),
            modifier = Modifier.width(64.dp),
        )
        OutlinedTextField(
            value = digit4,
            onValueChange = { onValueChangeLimited(it, setDigit4) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.Sentences
            ),
            modifier = Modifier.width(64.dp),
        )
        Button(
        onClick = {
            checkInput()
        },
        modifier = Modifier.padding(8.dp)
    ) {
        Image(imageVector = Icons.Filled.Check, contentDescription = null)
    }

    }
    if (!isInputCorrect) {
        Text(
            text = "Đã sai",
            color = MaterialTheme.colorScheme.error
        )
    }
    if (!showImages2To4) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Image(
                painter = painterResource(id = R.drawable.berry),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
        }
    }
    if (!showImages2To4) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Image(
                painter = painterResource(id = R.drawable.basket),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Image(
                painter = painterResource(id = R.drawable.ball),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
        }
    }

}
data class ImageItem(val id: Int, val resourceId: Int)

@Composable
fun ConvertImage(
    selectedImageId: Int = 1,
    onImageClick: (Int) -> Unit = {}
) {
    val imageList = remember {
        mutableStateListOf(
            ImageItem(1, R.drawable.berry),
            ImageItem(2, R.drawable.basket),
            ImageItem(3, R.drawable.bed),
            ImageItem(4, R.drawable.air),
            ImageItem(5, R.drawable.basket),
            ImageItem(6, R.drawable.ball),
            ImageItem(7, R.drawable.apple),
            ImageItem(8, R.drawable.beat),
            ImageItem(9, R.drawable.birdge),
            ImageItem(10, R.drawable.black)
            // Add more images if needed
        )
    }

    var startIndex by remember { mutableStateOf(0) }

    val displayedImages = imageList.subList(startIndex, startIndex + 2)

    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            displayedImages.forEach { imageItem ->
                Image(
                    painter = painterResource(id = imageItem.resourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .clickable {
                            onImageClick(imageItem.id)
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button to toggle between the first two and the next two images
        Button(
            onClick = {
                startIndex += 2
                if (startIndex >= imageList.size) {
                    startIndex = 0
                }
            }
        ) {
            Image(imageVector = Icons.Filled.Check, contentDescription =  null )
        }
    }

}



