package com.example.droidmentor.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R


@Composable
fun IconButton(
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Transparent
        ),
        contentPadding = PaddingValues(0.dp),
        modifier = modifier
    ) {
        icon()
    }
}

@Preview(showBackground = true)
@Composable
fun IconButtonPreview(){
    PreviewBox {
        IconButton(
            icon = {
                DroidIcon(
                    iconFile = R.drawable.back,
                    iconDesc = "Back",
                    iconSize = 24.dp
                )
            },
            onClick = {},
            modifier = Modifier.size(48.dp)
        )
    }

}