package com.transcard.coffe_coders_compose.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.transcard.coffe_coders_compose.ui.theme.Coffee_coders_composeTheme

@Composable
fun BodyText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun BodyTextPreview(){
    Coffee_coders_composeTheme {
        BodyText("Get crypto analysis, news and updates right to your inbox! Sign up here so you don't miss a single newsletter.")
    }
}