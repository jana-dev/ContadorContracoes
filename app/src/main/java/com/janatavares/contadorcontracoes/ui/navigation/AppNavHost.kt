package com.janatavares.contadorcontracoes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.janatavares.contadorcontracoes.ui.instructions.InstructionsScreen
import com.janatavares.contadorcontracoes.ui.main.MainScreen
import com.janatavares.contadorcontracoes.ui.welcome.WelcomeScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(
                onNavigateToInstructions = { navController.navigate("instructions") }
            )
        }
        composable("instructions"){
            InstructionsScreen(
                onNavigateToMain = { navController.navigate("main") }
            )
        }
        composable("main"){
            MainScreen()
        }

    }
}