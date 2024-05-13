package com.example.hideaway.ui.theme.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.hideaway.R
import com.example.hideaway.navigation.LOGIN_URL
import com.example.hideaway.navigation.SIGNUP_URL
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Splash(navController: NavController){
    Column(modifier = Modifier
        .paint(
            painterResource(id = R.drawable.safel),
            contentScale = ContentScale.FillBounds
        )
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        val coroutine = rememberCoroutineScope()
        coroutine.launch{ delay(3000)
        navController.navigate(LOGIN_URL)}
    }

}