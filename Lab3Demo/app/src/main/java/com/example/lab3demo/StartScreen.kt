package com.example.lab3demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab3demo.ui.theme.Lab3DemoTheme


@Composable
fun StartScreen(userInput: MutableState<String>, navController:NavController, modifier: Modifier=Modifier){

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "E/I Test")
        Text(text="Enter your name to start")

        TextField(value = userInput.value,
            onValueChange = {
                userInput.value=it
            } //what function it does
        )

        Button(onClick = { navController.navigate(Screen.QuestionScreen.route) },
            enabled=userInput.value.isNotEmpty()) {
            Text(text = "Start")
            
        }
    }
}

@Preview
@Composable
fun StartScreenPreview(){
    Lab3DemoTheme{
        Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

        }
    }
}