package com.example.robotremotecontrol.PROTOActivity


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@Composable
fun PROTOControlModesRadioButtons()
{
    val options = listOf("Nothing Selected", "Direct Control", "Hello routine", "SSR Calibration Action")

    // Set the start value to one of the options.
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(options[0] )} // TODO when the code words. Replace this with the next two lines

    // val onOptionSelected = remember { mutableStateOf(options[1] )}
    // val selectedOption = remember { mutableStateOf(options[1] )}

    // For each item in options(which we name text)
    options.forEach { text ->
        Row(
            Modifier
                .fillMaxWidth()
                .selectable(
                    selected = (text == selectedOption),
                    onClick = {
                        onOptionSelected(text)
                    }
                )
                .padding(horizontal = 16.dp)
        ) {
            RadioButton(
                selected = (text == selectedOption),
                onClick = { onOptionSelected(text) }
            )
            Text(
                text = text,
                style = MaterialTheme.typography.body1.merge(),
                modifier = Modifier.padding(start = 15.dp),
                overflow = TextOverflow.Visible // TODO why does this not work?
            )
        }
    }
}