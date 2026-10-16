package com.example.droidmentor.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.droidmentor.R

@Composable
fun Logo(
    modifier: Modifier = Modifier,
    logoId: Int = R.drawable.logo,
    contDesc: String = "DroidMentor",
    label: @Composable (() -> Unit)? = null
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painterResource(logoId),
            contentDescription = contDesc
        )
        label?.invoke()
    }
}