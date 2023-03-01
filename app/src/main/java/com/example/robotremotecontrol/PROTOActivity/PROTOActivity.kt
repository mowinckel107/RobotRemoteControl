package com.example.robotremotecontrol.PROTOActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.robotremotecontrol.ui.theme.RobotRemoteControlTheme

private const val Filename = "PROTOActivity.kt"


class PROTOActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopLevelComposable()
        }
    }
}

fun goToPROTOActivity(theContext : Context)
{
    theContext.startActivity(Intent(theContext, PROTOActivity::class.java))
}

@Preview
@Composable
private fun TopLevelComposable()
{
    RobotRemoteControlTheme( darkTheme = true)
    {
        Surface(modifier = Modifier.fillMaxSize())
        {
            Column()
            {
                PROTOHeadline()

                Row()
                {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth(0.47f)
                    )
                    {

                        PROTOControlModesRadioButtons()
                    }
                    Column()
                    {
                        PROTODirectControlButtons()
                    }
                }
            }
        }
    }
}

@Composable
fun PROTOHeadline()
{
    Text(
        text = "PROTO",
        modifier = Modifier.padding(8.dp),
        fontSize = 8.em,
        )
}