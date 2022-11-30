package com.transcard.coffe_coders_compose.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.transcard.coffe_coders_compose.ui.theme.Coffee_coders_composeTheme

@Composable
fun TitleText(title: String) {
    Text(text = title, style = MaterialTheme.typography.h3)
}

@Preview(showBackground = true)
@Composable
fun TitleTextPreview(){
    Coffee_coders_composeTheme {
        TitleText("Test")
    }
}