package com.example.droidmentor.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R

@Composable
fun DroidIcon(
    iconFile: Int,
    iconSize: Dp,
    modifier: Modifier = Modifier,
    tint: Color? = null,
    iconDesc: String? = null
){
    Icon(
        painter = painterResource(id = iconFile),
        contentDescription = iconDesc,
        tint = tint ?: MaterialTheme.colorScheme.onPrimary,
        modifier = modifier.size(iconSize)
    )
}

@Preview(showBackground = true)
@Composable
fun DroidIconPreview(){
    PreviewBox {
        DroidIcon(
            iconFile = R.drawable.back,
            iconDesc = "Back",
            iconSize = 24.dp
        )
    }

}