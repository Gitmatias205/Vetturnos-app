package com.tuempresa.vetturnos

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("registro") { RegistroScreen(navController) }
        composable("principal") { PantallaPrincipal(navController) }
        composable("dashboard") { DashboardScreen(navController) }
    }
}
