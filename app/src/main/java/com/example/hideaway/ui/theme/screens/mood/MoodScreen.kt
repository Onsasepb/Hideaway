package com.example.hideaway.ui.theme.screens.mood
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.ui.theme.Purple40

@Composable
fun MoodScreen(
    navController: NavHostController
) {
    // Remember the selected mood
    val selectedMood = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
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
            Text(text = "😄 Happy")          }

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


