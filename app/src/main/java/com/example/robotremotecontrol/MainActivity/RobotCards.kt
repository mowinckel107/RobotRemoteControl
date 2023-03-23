package com.example.robotremotecontrol.MainActivity

import android.app.Activity
import com.example.robotremotecontrol.PROTODirectControlActivity.goToPROTOActivity

import com.example.robotremotecontrol.R

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Variable to enable meaningful debug tags
private const val Filename = "RobotCards.kt"

// A data class to hold a function to go to a specific activity, and the name of that activity
// This is instead of using generic "Pair" objects, as their property names gives no information
data class RobotOptions(
    val goToActivityFunction: (Context) -> Unit,
    val nameOfActivity: String
)


// Step 1, make a model for the card
class RobotInformation(
    val name: String,
    val drawableID: Int,
    val options: List<RobotOptions>
)
{

}

// Step 2, make a function that finds all the needed data, turns it into models, and
// returns a list of them
// For now, this is hardcoded
@Composable
fun loadRobotInformation(): List<RobotInformation>
{
    val proto = RobotInformation(
        "PROTO",
        R.drawable.proto,
        listOf(
            RobotOptions(::goToPROTOActivity,"SSR Calibration Action"),
            RobotOptions(::goToPROTOActivity,"Direct Control")
        )
    )

    val dummyRobot1 = RobotInformation(
        "Dummy Robot 1",
        R.drawable.dummy_robot_1,
        listOf(
            RobotOptions(::goToMainActivity, "Dummy Option 1"),
            RobotOptions(::goToMainActivity, "Dummy Option 2")
        )
    )

    val dummyRobot2 = RobotInformation(
        "Dummy Robot 2",
        R.drawable.dummy_robot_2,
        listOf(
            RobotOptions(::goToMainActivity, "Dummy Option 1"),
            RobotOptions(::goToMainActivity, "Dummy Option 2")
        )
    )

    return listOf(proto, dummyRobot1, dummyRobot2)
}

// Step 3: We make a single card, based on the model we made in step 1
@Composable
fun RobotCard(robotInformation: RobotInformation)
{
    val context = LocalContext.current
    val activity = (context as? Activity)

    // We create a state of the composable by using the remember function:
    var isDisplayMenuShown by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable
            {
                // We have clicking the card change the state. This recomposes the
                // composable functions that depend in it, in this case "DropdownMenu"
                isDisplayMenuShown = !isDisplayMenuShown // Show or remove menu

                if (ISDEBUG) {
                    currentLine = Throwable().stackTrace[0].lineNumber - 1
                    Log.v(
                        Filename,
                        "The ${robotInformation.name} card was clicked on line $currentLine"
                    )
                }
            }
    )
    {
        Row()
        {
            Image(
                painter = painterResource(id = robotInformation.drawableID),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
            )
            Text(
                text = robotInformation.name,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .padding(12.dp)
            )


            DropdownMenu(
                // The dropdown menu is shown when the state says so this is "checked" whenever
                // DropdownMenu is composed or recomposed.
                expanded = isDisplayMenuShown,
                // When the menu is dismissed, it changes the state to stop showing the menu
                onDismissRequest = { isDisplayMenuShown = false }
            )
            {
                robotInformation.options.forEach{
                    // Creating dropdown menu item
                    DropdownMenuItem(
                        onClick = {
                            it.goToActivityFunction.invoke(context)
                            // We destroy MainActivity, since the way the app is intended to work
                            // means users will rarely go back to it. Nor does it take much to
                            // re-create if they do.
                            activity?.finish()
                        }
                    ) {
                        Text(text = it.nameOfActivity)
                    }
                }
            }
        }
    }
}

// Step 3.5 While designing smaller visual elements, like cards, it can be helpful to make
// a preview function just for that element.
@Preview
@Composable
fun RobotCardPreview()
{
    // Make dummy data for the preview to show
    val proto = RobotInformation(
        "PROTO",
        R.drawable.proto,
        listOf(
            RobotOptions(::goToPROTOActivity,"SSR Calibration Action"),
            RobotOptions(::goToPROTOActivity,"Direct Control")
        )
    )

    // Call function we want to preview
    RobotCard(proto)
}

// Step 4, make a function that returns all cards placed like we
// want them (in this case, vertical, by using "column")
@Composable
fun RobotCards()
{       loadRobotInformation().forEach { RobotCard(it) }
}