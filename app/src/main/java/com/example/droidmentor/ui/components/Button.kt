package com.example.droidmentor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DroidButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
){
    Button(
        onClick = onClick,
        modifier = modifier,
    ) {
        if(icon != null){
            icon()
            //spacing between icon ant text
            Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
        }
        Text(label)
    }
}

@Preview(showBackground = true)
@Composable
fun DroidButtonPreview() {
    var count by remember { mutableIntStateOf(0) }

    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                // Without icon
                DroidButton(
                    label = "No icon",
                    onClick = {}
                )

                // With icon
                DroidButton(
                    label = "Icon",
                    onClick = {},
                    icon = {
                        Box(
                            modifier = Modifier
                                .size(ButtonDefaults.IconSize)
                                .background(Color.Magenta)
                        )
                    }
                )
            }


            Column{
                Text(text = "counter: $count")
                // counter
                Row(
                    modifier = Modifier.padding(10.dp, 0.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    DroidButton(
                        label = "Counter up",
                        onClick = { count++ },
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(ButtonDefaults.IconSize)
                                    .background(Color.Green)
                            )
                        }
                    )

                    DroidButton(
                        label = "Counter down",
                        onClick = { if(count>0) count-- },
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(ButtonDefaults.IconSize)
                                    .background(Color.Red)
                            )
                        }
                    )
                }
            }
        }
    }
}