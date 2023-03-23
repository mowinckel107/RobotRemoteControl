package com.example.robotremotecontrol.PROTODirectControlActivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
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
import com.example.robotremotecontrol.MainActivity.ISDEBUG
import com.example.robotremotecontrol.MainActivity.goToMainActivity
import com.example.robotremotecontrol.ui.theme.RobotRemoteControlTheme

// Variable to enable meaningful debug tags
private const val Filename = "PROTOActivity.kt"



class PROTODirectControlActivity : ComponentActivity() {

    // Initiate it later, as it needs to be used to create the callback variable
    // but can only be initialized in the setContent function
    private lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopLevelComposable()

            context = LocalContext.current

            if (ISDEBUG) {
                Log.v(
                    Filename,
                    "---------- onCreate called on PROTODirectControlActivity"
                )
            }
        }

        // Main is destroyed, and we want the user to return to main.
        // So we change what the back button does in order to not quit out of the App
        val callback = onBackPressedDispatcher.addCallback(this)
        {
            val activity : Activity? = (context as? Activity)
            goToMainActivity(context)
            activity?.finish()
        }
        callback.isEnabled
    }



    override fun onDestroy() {
        super.onDestroy()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "---------- onDestroy called on PROTODirectControlActivity"
            )
        }
    }

    override fun onStart() {
        super.onStart()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "---------- onStart called on PROTODirectControlActivity"
            )
        }
    }

    override fun onStop() {
        super.onStop()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "---------- onStop called on PROTODirectControlActivity"
            )
        }
    }

    override fun onResume() {
        super.onResume()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "---------- onResume called on PROTODirectControlActivity"
            )
        }
    }

    override fun onPause() {
        super.onPause()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "---------- onPause called on PROTODirectControlActivity"
            )
        }
    }

    override fun onRestart() {
        super.onRestart()

        if (ISDEBUG) {
            Log.v(
                Filename,
                "---------- onRestart called on PROTODirectControlActivity"
            )
        }
    }
}

// Top level function to make it neater to go to this activity.
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
    val context = LocalContext.current
    val activity = (context as? Activity)

    Button(
        onClick = {
            // Calling explicitly, since Main is likely to be destroyed, and the intention is not
            // For this action to quit the app
            goToMainActivity(context)
            activity?.finish() },

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

