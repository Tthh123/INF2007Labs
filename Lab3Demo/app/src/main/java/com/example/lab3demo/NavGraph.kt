package com.example.lab3demo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Screen (val route: String){
    object StartScreen: Screen(route="start_screen")
    object QuestionScreen: Screen(route="question_screen")
    object CompletedScreen: Screen(route="completed_screen")
}

@Composable
fun NavGraph(navController: NavHostController){
    var userInput = remember {
        mutableStateOf("")
    }
    var count = remember {
        mutableStateOf(0)
    }
    var selectedItem = remember { mutableStateOf("")}
    var score= remember {
        mutableStateOf(0)
    }
    var totalscore= remember {
        mutableStateOf(0)
    }
    NavHost(navController = navController, startDestination = Screen.StartScreen.route){
        composable(Screen.StartScreen.route){
            StartScreen(userInput,navController)
        }
        composable(Screen.QuestionScreen.route){
            QuestionScreen(count,selectedItem,score,totalscore,navController)
        }
        composable(Screen.CompletedScreen.route){
            CompletedScreen(userInput,count,score,totalscore,navController)
        }
    }
}