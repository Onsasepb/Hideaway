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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hideaway.R
import com.example.hideaway.navigation.ADD_PATIENTS_URL
import com.example.hideaway.navigation.CHAT_URL
import com.example.hideaway.navigation.CONTACT_URL
import com.example.hideaway.navigation.GRATITUDE_URL
import com.example.hideaway.navigation.LOGIN_URL
import com.example.hideaway.navigation.MOOD_URL
import com.example.hideaway.navigation.SAFETY_URL
import com.example.hideaway.navigation.SPLASH_URL
import com.example.hideaway.navigation.STRENGTHS_URL
import com.example.hideaway.navigation.THOUGHT_URL
import com.example.hideaway.ui.theme.HideawayTheme
import com.example.hideaway.ui.theme.Purple40

@Composable
fun Menu(navController : NavHostController) {
    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
        Text(
            text = "Menu",
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Purple40,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 135.dp)

        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)

        )
        {
            Card(modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .clickable { navController.navigate(MOOD_URL) }
            )
            {
                Row(modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.safer), contentDescription = "")
                    Text(
                        text = "Mood",
                        fontFamily = FontFamily.Cursive,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
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

        Card(modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .clickable { navController.navigate(SAFETY_URL) }
        )
        {
            Row(modifier = Modifier.fillMaxSize()) {
                Image(painter = painterResource(id = R.drawable.safeu), contentDescription = "")
                Text(
                    text = "Safety Plan",
                    fontFamily = FontFamily.Cursive,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding
                        (
                        top = 20.dp
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .clickable { navController.navigate(CONTACT_URL) }
        )
        {
            Row(modifier = Modifier.fillMaxSize()) {
                Image(painter = painterResource(id = R.drawable.safeq  ), contentDescription = "")
                Text(
                    text = "Contact us",
                    fontFamily = FontFamily.Cursive,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding
                        (
                        top = 20.dp
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .clickable { navController.navigate(SPLASH_URL) }
        )
        {
            Row(modifier = Modifier.fillMaxSize()) {
                Image(painter = painterResource(id = R.drawable.safet  ), contentDescription = "")
                Text(
                    text = "Logout",
                    fontFamily = FontFamily.Cursive,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding
                        (
                        top = 20.dp
                    )
                )
            }
        }



    }
}
@Composable
@Preview(showBackground = true)
fun MenuScreenPreview(){
    HideawayTheme {
        Menu(navController = rememberNavController())

    }
}