package com.example.robotremotecontrol.PROTOActivity

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


fun HTTPcallForward()
{

}

@Composable
fun PROTODirectControlButtons()
{


    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(5.dp)
    )
    {
        val interactionSource = remember { MutableInteractionSource() }
        val interactions = remember { mutableStateOf(interactionSource) }
        LaunchedEffect(interactionSource) {
            //interactionSource.interactions.

        }

        Text(text = "Forward")
    }

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(5.dp)
    )
    {
        Text(text = "Forward")
    }

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(5.dp)
    )
    {
        Text(text = "Left")
    }

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(5.dp)
    )
    {
        Text(text = "Right")
    }
}



