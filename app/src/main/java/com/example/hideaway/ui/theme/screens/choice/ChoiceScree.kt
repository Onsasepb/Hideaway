package com.example.hideawayapplication.ui.theme.screens.choice

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.hideaway.navigation.HOME_URL
import com.example.hideaway.ui.theme.HideawayTheme
import com.example.hideaway.ui.theme.Purple40
import com.example.hideaway.ui.theme.screens.home.HomeScreen

@Composable
fun ChoiceScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .paint(
                painterResource(id = R.drawable.project1),
                contentScale = ContentScale.FillBounds
            )
            .fillMaxSize()
    ) {
        Text(
            text = "Hideaway",
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Purple40,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 90.dp, top = 50.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "LOGIN AS:",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 140.dp, top = 350.dp))

Spacer(modifier = Modifier.height(20.dp))
        Text(text = "PATIENT",
            fontFamily = FontFamily.Cursive,
            fontSize = 40.sp,
            color = Color.White,
            modifier = Modifier
                .clickable { navController.navigate(HOME_URL) }
                .padding(start = 140.dp))




        Text(text = "or",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 195.dp))
            Spacer(modifier = Modifier.height(10.dp))
        Text(text = "DOCTOR",
            fontFamily = FontFamily.Cursive,
            fontSize = 40.sp,
            color = Color.White,
            modifier = Modifier
                .clickable { navController.navigate(ADD_PATIENTS_URL) }
                .padding(start = 140.dp))




    }


}
@Composable
@Preview(showBackground = true)
fun ChoiceScreenPreview(){
    HideawayTheme {
        ChoiceScreen(navController = rememberNavController())
    }
}