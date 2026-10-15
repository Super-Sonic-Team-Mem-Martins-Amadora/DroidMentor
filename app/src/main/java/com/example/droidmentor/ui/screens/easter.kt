package com.example.droidmentor.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.PreviewBox
import com.example.droidmentor.ui.components.spacing

private data class EasterEggs(
    val title : String,
    val desc : String,
    val egg : Int
)

private val easterEggs = arrayOf(
    EasterEggs(
        title = "Evil Shadow!!",
        desc = "Did you even beat Promised Consort Radahn?",
        egg = R.raw.dadow
    ),
    EasterEggs(
        title = "Holy Sonic!",
        desc = "Behold The power of Sonic!",
        egg = R.raw.holy_donic
    ),
    EasterEggs(
        title = "Good hol' Donic!!",
        desc = "Not big on customization right?",
        egg = R.raw.plain_donic
    ),
)

@Composable
fun Easter(dark : Boolean = isSystemInDarkTheme()){
    val easterEgg =
        when {
            dark -> easterEggs[0]
            else -> easterEggs[1]
        }

    Scaffold(
        topBar = {
            Column {
                Header(
                    title = easterEgg.title,
                    button = {
                        IconButton(
                            icon = {
                                DroidIcon(
                                    iconFile = R.drawable.back,
                                    iconDesc = "Back",
                                    iconSize = 24.dp,
                                )
                            },
                            onClick = {},
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.logo,
                            iconSize = 50.dp,
                            iconDesc = "DroidMentor",
                            tint = Color.Unspecified
                        )
                    }
                )
                Spacer(Modifier.height(spacing))
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = easterEgg.desc,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            DroidIcon(
                iconFile = easterEgg.egg,
                iconSize = 500.dp,
                tint = Color.Unspecified
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EasterPreview(){
    val dark = true
    PreviewBox(padding = 20.dp, dark = dark) {
        Easter(dark = dark)
    }
}