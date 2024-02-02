package com.example.lab3demo

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab3demo.ui.theme.Lab3DemoTheme
import java.lang.Exception


@Composable
fun CompletedScreen(userInput: MutableState<String>,count: MutableState<Int>,
                    score:MutableState<Int>,totalscore:MutableState<Int>,
                    navController: NavController, modifier: Modifier = Modifier){
    val floatScore=score.value.toFloat()
    val totalFloatScore=totalscore.value.toFloat()
    val iScore=floatScore/totalFloatScore
    val eScore=(totalFloatScore-floatScore)/totalFloatScore
    val context = LocalContext.current
Column (
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
){

    Text(text = "Completed")
    Divider(thickness = 2.dp)
    Text(text = "Hi ${userInput.value}, \n"+"You are ${iScore}% introvert and ${eScore}% extrovert")

        Button(onClick = {
            val intent=Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_SUBJECT, "Your Personality Test Result")
                putExtra(Intent.EXTRA_TEXT, "Hi ${userInput.value}, \nYou are ${iScore}% introvert and ${eScore}% extrovert.")
            }

            try {
                context.startActivity(Intent.createChooser(intent, "Send email..."))
            }
            catch (e:Exception){
                Toast.makeText(context, "No email clients installed.", Toast.LENGTH_SHORT).show()
            }


        }) {
            Text(text = "Share your result")
        }
        Button(onClick = {
            count.value=0
            score.value=0
            totalscore.value=0
            navController.navigate(Screen.QuestionScreen.route)
        }) {
            Text(text = "Restart the test")
        }

}
}

@Preview
@Composable
fun CompletedScreenPreview(){
    Lab3DemoTheme{
        Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

        }
    }
}