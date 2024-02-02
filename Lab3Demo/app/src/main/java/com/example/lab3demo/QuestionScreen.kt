package com.example.lab3demo

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab3demo.ui.theme.Lab3DemoTheme
import edu.inf2007.eitest.testData

@Composable
fun QuestionScreen(
    count: MutableState<Int> ,
    selectedItem:MutableState<String> ,
    score:MutableState<Int>,totalscore:MutableState<Int>,
    navController: NavController = rememberNavController(), modifier: Modifier = Modifier,
    ){



    Column {
        Text(text = "Question ${count.value+1}")
        Text(text = testData.questionsBank[count.value].question)
        Divider(thickness = 2.dp)
        testData.questionsBank[count.value].options.forEachIndexed{ind,item->
            Row (horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                RadioButton(selected = item==selectedItem.value, onClick = {
                    selectedItem.value=item
                    score.value+=testData.questionsBank[count.value].scores[ind]
                    totalscore.value+=testData.questionsBank[count.value].scores.max()}

                )
                Text(text = testData.questionsBank[count.value].options[1])
            }

        }
        Row{
            Button(modifier=Modifier.weight(1f),onClick = { /*TODO*/ }) {
                Text(text = "Cancel")
            }
            Button(modifier=Modifier.weight(1f),onClick = {
                count.value++
                if (count.value>=5){
                    navController.navigate(Screen.CompletedScreen.route)
                }
                else{
                    navController.navigate(Screen.QuestionScreen.route)
                }

            }) {
                Text(text = "Next")
            }
        }
    }
}

@Preview
@Composable
fun SuestionScreenPreview(){
    Lab3DemoTheme{
        Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

        }
    }
}