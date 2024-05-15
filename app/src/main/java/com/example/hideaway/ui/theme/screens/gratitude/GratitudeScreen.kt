package com.example.hideawayapplication.ui.theme.screens.gratitude

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hideaway.ui.theme.HideawayTheme
import com.example.hideaway.ui.theme.Purple40

@Composable
fun Gratitude(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
            .verticalScroll(rememberScrollState())
            .background(color = Purple40)

    ) {
        val mContext = LocalContext.current

        Text(
            text = "Gratitude Diary",
            fontFamily = FontFamily.Cursive,
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 50.dp)
        )
    }}


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {
    val noteText = remember { mutableStateOf("") }
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = noteText.value,
            onValueChange = { noteText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(start = 20.dp, top = 45.dp, end = 20.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            label = { Text("I AM GRACIOUS FOR;",
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.ExtraBold)}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Open another app to take notes, replace "com.example.notes" with the package name of the notes app
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("package:com.example.notes")
            context.startActivity(intent)
        }) {
            Text("Open Notes App")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GratitudeScreenPreview(){
    HideawayTheme {
        Gratitude(navController = rememberNavController())
        NoteScreen()

    }
}