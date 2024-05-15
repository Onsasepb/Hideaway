package com.example.hideawayapplication.ui.theme.screens.mood

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hideaway.navigation.HOME_URL
import com.example.hideaway.navigation.MENU_URL
import com.example.hideaway.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodScreen(
    navController: NavHostController
) {
    // Remember the selected mood
    val selectedMood = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        TopAppBar(title = { Text(text = "MOOD",
            color = Purple40,
            fontFamily  = FontFamily.Cursive,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start =70.dp))
        },

//Background color for a top app Bar
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),
//end
//icon
            //Icons before
            navigationIcon = {
                IconButton(onClick = { navController.navigate(MENU_URL) }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "menu",
                        //Color for Icon
                        tint = Purple40
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "How are you feeling today?",
            modifier = Modifier.padding(16.dp),
            color = Purple40
        )

        Button(
            onClick = {
                selectedMood.value = "Happy"
                onMoodSelected("Happy")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "😁 Happy")
        }
        Button(
            onClick = {
                selectedMood.value = "Excited"
                onMoodSelected("Excited")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "😃 Excited")
        }
        Button(
            onClick = {
                selectedMood.value = "Bored"
                onMoodSelected("Bored")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "🥱 Bored")
        }
        Button(
            onClick = {
                selectedMood.value = "Sad"
                onMoodSelected("Sad")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "😓 Sad")
        }
        Button(
            onClick = {
                selectedMood.value = "Despondent"
                onMoodSelected("Anx")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "😰 Anxious")
        }
        Button(
            onClick = {
                selectedMood.value = "Despondent"
                onMoodSelected("Despondent")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "😰😭 Despondent")
        }

        Text(
            text = "Selected mood: ${selectedMood.value}",
            modifier = Modifier.padding(16.dp),
            color = Purple40
        )
    }
}

fun onMoodSelected(s: String) {

}


@Preview
@Composable
fun PreviewMoodScreen() {
    MoodScreen(navController = rememberNavController())
}


