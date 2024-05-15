package com.example.hideaway.ui.theme.screens.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.example.hideaway.navigation.MENU_URL
import com.example.hideaway.ui.theme.HideawayTheme
import com.example.hideaway.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController) {
    Column(
        modifier = Modifier
            .paint(
                painterResource(id = R.drawable.safef),
                contentScale = ContentScale.FillBounds
            )
            .fillMaxSize()

    ) {
        val mContext = LocalContext.current

        Text(
            text = "Home",
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Purple40,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 135.dp)
        )
        OutlinedButton(onClick = {
            navController.navigate(MENU_URL)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 600.dp)
        ) {
            Text(text = "MENU",
                color = Purple40,
                fontWeight = FontWeight.Bold)
        }



//


    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HideawayTheme {
        HomeScreen(navController = rememberNavController())
    }
}