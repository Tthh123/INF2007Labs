package com.example.composetut

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetut.ui.theme.ComposetutTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposetutTheme{
                Surface {
                    MessageCard(msg=Message("Travis","He is handsome"))
                }
            }
        }
    }
}

data class Message(val author:String, val body:String)

@Preview(name="Light Mode")
@Preview(
    uiMode=Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name="Dark mode"
)
@Composable
fun PreviewCard(){
    ComposetutTheme{
        Surface {
            MessageCard(msg=Message("Travis","He is handsome"))
        }
    }

}

@Composable
fun MessageCard(msg:Message){
    Row (modifier=Modifier.padding(all=8.dp)){
        Image(painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Contact profile picture" ,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary))
        Spacer(modifier=Modifier.width(8.dp))
        Column {
            Text(text = msg.author,
                color=MaterialTheme.colorScheme.primary,
                style=MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Surface (shape=MaterialTheme.shapes.medium, shadowElevation = 1.dp){
                Text(
                    text=msg.body,
                    modifier = Modifier.padding(all=4.dp),
                    style=MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}