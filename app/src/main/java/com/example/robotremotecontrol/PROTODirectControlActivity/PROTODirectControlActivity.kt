package com.example.robotremotecontrol.PROTODirectControlActivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.robotremotecontrol.ui.theme.RobotRemoteControlTheme

private const val Filename = "PROTOActivity.kt"


class PROTODirectControlActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopLevelComposable()
        }
    }
}

fun goToPROTOActivity(theContext : Context)
{
    theContext.startActivity(Intent(theContext, PROTODirectControlActivity::class.java))
}

@Preview
@Composable
private fun TopLevelComposable()
{
    RobotRemoteControlTheme( darkTheme = true)
    {
        Surface(modifier = Modifier.fillMaxSize())
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                PROTOHeadline()
                ReturnToMainButton()
                Spacer(modifier = Modifier.height(20.dp))

                ForwardButton()

                Spacer(modifier = Modifier.height(10.dp))

                Row( )
                {
                    LeftButton()

                    Spacer(modifier = Modifier.width(130.dp))

                    RightButton()
                }

                Spacer(modifier = Modifier.height(10.dp))

                BackwardButton()
            }
        }
    }
}


@Composable
fun PROTOHeadline()
{
    Text(
        text = "PROTO - Direct Control",
        modifier = Modifier
                .padding(30.dp,5.dp),
        fontSize = 7.em,
        )
}

@Composable
fun ReturnToMainButton()
{
    val activity = (LocalContext.current as? Activity)

    Button(
        onClick = { activity?.finish()},
        modifier = Modifier.padding(5.dp)
    )
    {
        Text(text = "Back to main menu")
    }
}

@Composable
fun ForwardButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(5.dp)
    )
    {
        Text(text = "Forward")
    }
}

@Composable
fun BackwardButton() {

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(5.dp)
    )
    {
        Text(text = "Backward")
    }
}

@Composable
fun LeftButton() {

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(5.dp)
    )
    {
        Text(text = "Left")
    }
}

@Composable
fun RightButton() {

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(5.dp)
    )
    {
        Text(text = "Right")
    }
}

