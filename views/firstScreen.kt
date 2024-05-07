package com.sergio.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.sergio.views.navigation.taskScreens
import kotlinx.coroutines.delay

@Composable
fun firstScreen(navController: NavController){
    LaunchedEffect(key1 = true){
        delay(3500L)
        /*
        if(FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()){
            navController.navigate(taskScreens.LoginsScreen_2.name)
        }
        else{
            navController.navigate(taskScreens.home.name)
            popUpTo(taskScreens.SplashScreen.name){
                inclusive =true
            }
        }
        */
        navController.navigate(taskScreens.LoginsScreen_2.name)
    }
    Text(text = "TASK MANAGER")
}