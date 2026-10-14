package com.example.droidmentor.ui.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R

@Composable
fun SearchInput(
    onHandler: (text: String) -> Unit,
    modifier: Modifier = Modifier
){
    var input by remember { mutableStateOf("") }

    TextField(
        value = input,
        onValueChange = {
            input = it
            onHandler(input)
        },
        leadingIcon = {
            DroidIcon(
                R.drawable.glass,
                24.dp
            )
        },
        placeholder = {
            Text(
                "Search a chat",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium,
        singleLine = true,
        modifier = modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp)
            ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
    )
}

@Preview(showBackground = true)
@Composable
fun SearchInputPreview(){
    PreviewBox(20.dp) {
        SearchInput(
            onHandler = { input ->
                Log.d("SearchInput",input)
            },
        )
    }
}