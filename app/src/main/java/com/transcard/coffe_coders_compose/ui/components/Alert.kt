package com.transcard.coffe_coders_compose.ui.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.transcard.coffe_coders_compose.ui.theme.Coffee_coders_composeTheme

@Composable
fun Alert(
    title: String,
    message: String?,
    onClose: () -> Unit
) {
    if(!message.isNullOrEmpty()) {
        AlertDialog(
            onDismissRequest = { onClose() },
            title = { Text(text = title, style = TextStyle(color = Color.Black)) },
            text = { Text(text = message) },
            confirmButton = {
                Button(onClick = { onClose() }){
                    Text(text = "Ok")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlertPreview(){
    Coffee_coders_composeTheme {
        Alert(title = "Title", message = "Long description for the alert") {}
    }
}