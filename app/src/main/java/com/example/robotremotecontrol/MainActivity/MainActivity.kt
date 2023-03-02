package com.example.robotremotecontrol.MainActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.robotremotecontrol.ui.theme.RobotRemoteControlTheme


internal const val ISDEBUG : Boolean = true
internal var currentLine : Int = 0

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            TopLevelComposable()
        }
    }
}

fun goToMainActivity(theContext : Context)
{
    theContext.startActivity(Intent(theContext, MainActivity::class.java))
}

@Preview
@Composable
private fun TopLevelComposable()
{
    RobotRemoteControlTheme( darkTheme = true)
    {
        Surface(modifier = Modifier.fillMaxSize())
        {
            // Image(painter = , contentDescription = )
            Column()
            {
                Text(
                    text = "Welcome back Mow\n\rGood to see you",
                    modifier = Modifier.padding(24.dp),
                    fontSize = 8.em,
                    textAlign = TextAlign.Center
                )
                RobotCardList(robotInformation = loadRobotInformation())
            }
        }
    }
}