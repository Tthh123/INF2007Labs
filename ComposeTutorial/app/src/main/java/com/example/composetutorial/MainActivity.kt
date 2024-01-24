package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                myFunc(modifier=Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun myFunc(modifier: Modifier=Modifier,names: List<String> = listOf("World", "Compose")){
    Surface(modifier=modifier,color=MaterialTheme.colorScheme.background) {
Column {
    for (name in names){
        Greeting(name = name)
    }
}
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary, modifier = modifier.padding(vertical=4.dp, horizontal = 8.dp)) {
        Column() {
            Text(text = "Hello ")
            Text(text = "$name")
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        myFunc()
    }
}