package com.example.robotremotecontrol.MainActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.robotremotecontrol.ui.theme.RobotRemoteControlTheme


// Variables to enable and disable a custom debug mode. Since changing to release in Android studio
// Requires a certificate from Google.
internal const val ISDEBUG : Boolean = true
internal var currentLine : Int = 0

// Variable to enable meaningful debug tags
private const val Filename = "MainActivity.kt"

// This class is for Activity lifecycle things only
// Composable functions should be placed in the TopLevelComposable function
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            TopLevelComposable()
        }

        if (ISDEBUG) {
            Log.v(
                Filename,
                "onCreate called on MainActivity"
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "onDestroy called on MainActivity"
            )
        }
    }

    override fun onStart() {
        super.onStart()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "onStart called on MainActivity"
            )
        }
    }

    override fun onStop() {
        super.onStop()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "onStop called on MainActivity"
            )
        }
    }

    override fun onResume() {
        super.onResume()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "onResume called on MainActivity"
            )
        }
    }

    override fun onPause() {
        super.onPause()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "onPause called on MainActivity"
            )
        }
    }

    override fun onRestart() {
        super.onRestart()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "onRestart called on MainActivity"
            )
        }
    }
}

// Top level function to make it neater to go to this activity.
fun goToMainActivity(theContext : Context)
{
    theContext.startActivity(Intent(theContext, MainActivity::class.java))
}


// Private function, so that all activities can have the same named function
// It takes no argument, so it can be previewed, and since it contains all composable functions
// that means the entire layout can be previewed

// The TopLevelComposable function should only contain standard Composable functions dealing
// with layout.
// Graphical elements should be made in user made composable functions and called in
// TopLevelComposable where they need to be placed.
// Simple Graphical elements  should be in functions bellow TopLevelComposable, larger ones
// in their own .kt file

// This ensures a separation of concerns, IE, design of graphical elements, and placement of
// graphical elements, and ensures maximum Composable function reusability.
@Preview
@Composable
private fun TopLevelComposable()
{

    if (ISDEBUG) {
        Log.v(
            Filename,
            "\n\n\n"
        )
    }

    RobotRemoteControlTheme( darkTheme = true)
    {
        Surface(modifier = Modifier.fillMaxSize())
        {
            // Image(painter = , contentDescription = )
            Column()
            {
                MainScreenGreeting()

                Column()
                {
                    RobotCards()
                }
            }
        }
    }
}

@Composable
fun MainScreenGreeting()
{
    Text(
        text = "Welcome back Mow\n\rGood to see you",
        modifier = Modifier.padding(24.dp),
        fontSize = 8.em,
        textAlign = TextAlign.Center
    )

}