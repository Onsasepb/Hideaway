package com.example.hideaway.ui.theme.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hideaway.R
import com.example.hideaway.navigation.CHAT_URL
import com.example.hideaway.navigation.GRATITUDE_URL
import com.example.hideaway.navigation.MOOD_URL
import com.example.hideaway.navigation.SAFETY_URL
import com.example.hideaway.navigation.STRENGTHS_URL
import com.example.hideaway.navigation.THOUGHT_URL

@Composable
fun Menu(navController : NavHostController) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        )
        {
            Card(modifier = Modifier
                .height(80.dp)
                .width(160.dp)
                .clickable { navController.navigate(MOOD_URL) }
            )
            {
                Row(modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.safea), contentDescription = "")
                    Text(
                        text = "Mood",
                        fontFamily = FontFamily.Cursive,
                        fontSize = 20.sp,
                        modifier = Modifier.padding
                            (
                            top = 20.dp,
                            start = 5.dp
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Card(modifier = Modifier
                .height(80.dp)
                .width(160.dp)
                .clickable { navController.navigate(CHAT_URL) }
            )
            {
                Row(modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.safea), contentDescription = "")
                    Text(
                        text = "Activities",
                        fontFamily = FontFamily.Cursive,
                        fontSize = 20.sp,
                        modifier = Modifier.padding
                            (
                            top = 20.dp,
                            start = 5.dp
                        )
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(20.dp))

//second card
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        )
        {
            Card(modifier = Modifier
                .height(80.dp)
                .width(160.dp)
                .clickable { navController.navigate(STRENGTHS_URL) }
            )
            {
                Row(modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.safea), contentDescription = "")
                    Text(
                        text = "Strengths",
                        fontFamily = FontFamily.Cursive,
                        fontSize = 20.sp,
                        modifier = Modifier.padding
                            (
                            top = 20.dp,
                            start = 5.dp
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Card(modifier = Modifier
                .height(80.dp)
                .width(160.dp)
                .clickable { navController.navigate(GRATITUDE_URL) }
            )
            {
                Row(modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.safea), contentDescription = "")
                    Text(
                        text = "Gratitude Diary",
                        fontFamily = FontFamily.Cursive,
                        fontSize = 20.sp,
                        modifier = Modifier.padding
                            (
                            top = 20.dp,
                            start = 5.dp
                        )
                    )
                }
            }


        }
        Spacer(modifier = Modifier.height(20.dp))
        //Fourth Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        )
        {
            Card(modifier = Modifier
                .height(80.dp)
                .width(160.dp)
                .clickable { navController.navigate(THOUGHT_URL) }
            )
            {
                Row(modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.safea), contentDescription = "")
                    Text(
                        text = "Thought Diary",
                        fontFamily = FontFamily.Cursive,
                        fontSize = 20.sp,
                        modifier = Modifier.padding
                            (
                            top = 20.dp,
                            start = 5.dp
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Card(modifier = Modifier
                .height(80.dp)
                .width(160.dp)
                .clickable { navController.navigate(SAFETY_URL) }
            )
            {
                Row(modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.safea), contentDescription = "")
                    Text(
                        text = "Safety Plan",
                        fontFamily = FontFamily.Cursive,
                        fontSize = 20.sp,
                        modifier = Modifier.padding
                            (
                            top = 20.dp,
                            start = 5.dp
                        )
                    )
                }
            }

        }
    }
}