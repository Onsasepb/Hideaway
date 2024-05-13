package com.example.hideaway.ui.theme.screens.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hideaway.R
import com.example.hideaway.data.AuthViewModel
import com.example.hideaway.navigation.LOGIN_URL
import com.example.hideaway.ui.theme.HideawayTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController:NavHostController){
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
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 90.dp, top =50.dp))
        Spacer(modifier = Modifier.height(20.dp))

        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text(text = "Enter name")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription ="Email" ) },
            modifier = Modifier.padding(start = 30.dp)

        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Enter email")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription ="Email" ) },
            modifier = Modifier.padding(start = 30.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Enter password")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription ="Password" )},
            modifier = Modifier.padding(start = 30.dp)

        )

        Spacer(modifier = Modifier.height(20.dp))

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        OutlinedButton(onClick = {
            authViewModel.signup(name, email, password)
        },
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp)
                .fillMaxWidth())
        {
            Text(text = "Register",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

        }
            


        Spacer(modifier = Modifier.height(20.dp))
    Text(text = "or",
        textAlign = TextAlign.Center,
        color = Color.White,
        fontSize = 30.sp,
        modifier = Modifier.padding(start = 175.dp))
    Spacer(modifier = Modifier.height(10.dp))
    Text(text = "Login",
        fontFamily = FontFamily.Cursive,
        fontSize = 40.sp,
        color = Color.White,
        modifier = Modifier
            .clickable { navController.navigate(LOGIN_URL) }
            .padding(start = 140.dp))




}
    }


@Composable
@Preview(showBackground = true)
fun SignupScreenPreview(){
    HideawayTheme {
        SignupScreen(navController = rememberNavController())
    }
}