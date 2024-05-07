package com.sergio.views.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sergio.views.Content
import com.sergio.views.Loginscreen_2
import com.sergio.views.firstScreen
import com.sergio.views.progress_Group

@Composable
fun taskNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = taskScreens.SplashScreen.name )
    {
        composable(taskScreens.LoginsScreen_2.name){
            Loginscreen_2( navController=navController)
        }

        composable(taskScreens.home.name){
            Content(navController=navController)
        }

        composable(taskScreens.metrics.name){
            progress_Group(navController = navController)
        }

        composable(taskScreens.SplashScreen.name){
            firstScreen(navController=navController)
        }
    }
}