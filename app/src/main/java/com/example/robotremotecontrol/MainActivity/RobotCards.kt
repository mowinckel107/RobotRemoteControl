package com.example.robotremotecontrol.MainActivity

import com.example.robotremotecontrol.PROTOActivity.goToPROTOActivity

import com.example.robotremotecontrol.R

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


private const val Filename = "RobotCards.kt"

// Step 1, make a model for the card
class RobotInformation(
    var name: String = "",
    var drawableID: Int = 0,
    var nextActivity: (Context) -> Unit // a function that takes Context and returns nothing
)

// Step 2, make a function that finds all the needed data,
// turns it into models, and returns a list of them
@Composable
fun loadRobotInformation(): List<RobotInformation>
{
    val proto = RobotInformation(
        "PROTO",
        R.drawable.proto,
        ::goToPROTOActivity
    )

    val dummyRobot1 = RobotInformation(
        "Dummy Robot 1",
        R.drawable.dummy_robot_1,
        ::goToMainActivity
    )

    val dummyRobot2 = RobotInformation(
        "Dummy Robot 2",
        R.drawable.dummy_robot_2,
        ::goToMainActivity
    )

    return listOf(proto, dummyRobot1, dummyRobot2)
}

// Step 3: We make a single card, based on the model we made in step 1
@Composable
fun RobotCard(robotInformation: RobotInformation)
{
    val mContext = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable
            {
                robotInformation.nextActivity(mContext)

                if (ISDEBUG) {
                    currentLine = Throwable().stackTrace[0].lineNumber-1
                    Log.v("From $Filename, line $currentLine", "The ${robotInformation.name} card was clicked!")
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
        ::goToPROTOActivity
    )

    // Call function we want to preview
    RobotCard(proto)
}

// Step 4, make a function that returns all cards placed like we
// want them (in this case, vertical, by using "column")
@Composable
fun RobotCardList(robotInformation: List<RobotInformation>) {

    Column() {
        robotInformation.forEach { RobotCard(it) }
    }
}