package com.example.hideaway.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hideaway.ui.theme.screens.home.HomeScreen
import com.example.hideaway.ui.theme.screens.login.LoginScreen
import com.example.hideaway.ui.theme.screens.patients.AddPatientsScreen
import com.example.hideaway.ui.theme.screens.patients.ViewPatientsScreen
import com.example.hideaway.ui.theme.screens.signup.SignupScreen
import com.example.hideaway.ui.theme.screens.splash.Splash
import com.example.hideaway.ui.theme.screens.strengths.Strength
import com.example.hideaway.ui.theme.screens.thought.Thought
import com.example.hideaway.ui.theme.screens.chat.Chat
import com.example.hideaway.ui.theme.screens.other.Other
import com.example.hideawayapplication.ui.theme.screens.choice.ChoiceScreen
import com.example.hideaway.ui.theme.screens.contact.Contact
import com.example.hideawayapplication.ui.theme.screens.gratitude.Gratitude
import com.example.hideaway.ui.theme.screens.menu.Menu
import com.example.hideawayapplication.ui.theme.screens.mood.MoodScreen
import com.example.hideaway.ui.theme.screens.safety.Safety
import com.example.hideaway.ui.theme.screens.strategies.Strategies
import com.example.hideawayapplication.ui.theme.screens.warning.Warnings

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASH_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOME_URL){
            HomeScreen(navController = navController)
        }
        composable(ADD_PATIENTS_URL){
            AddPatientsScreen(navController = navController)
        }
        composable(VIEW_PATIENTS_URL){
            ViewPatientsScreen(navController = navController)
        }
        composable(SPLASH_URL){
            Splash(navController = navController)
        }
        composable(MOOD_URL){
            MoodScreen(navController = navController)
        }
        composable(CHAT_URL){
            Chat(navController = navController)
        }
        composable(STRENGTHS_URL){
            Strength(navController = navController)
        }


        composable(GRATITUDE_URL){
            Gratitude(navController = navController)
        }
        composable(THOUGHT_URL){
            Thought(navController = navController)
        }
        composable(SAFETY_URL){
            Safety(navController = navController)
        }
        composable(MENU_URL){
            Menu(navController = navController)
        }
        composable(CHOICE_URL){
            ChoiceScreen(navController = navController)
        }
        composable(WARNINGS_URL){
            Warnings(navController = navController)
        }
        composable(STRATEGIES_URL){
            Strategies(navController = navController)
        }
        composable(OTHER_URL){
            Other(navController = navController)
        }
        composable(CONTACT_URL){
            Contact(navController = navController)
        }

    }
}