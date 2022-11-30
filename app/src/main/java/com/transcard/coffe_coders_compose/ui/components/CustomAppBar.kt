package com.transcard.coffe_coders_compose.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.transcard.coffe_coders_compose.ui.theme.Coffee_coders_composeTheme

typealias NavigationAction = () -> Unit

@Composable
fun CustomAppBar(
    title: String? = null,
    navigationIcon: ImageVector? = null,
    navigationAction: NavigationAction? = null
) {
    val titleText = title ?: ""
    if (navigationIcon != null && navigationAction != null) {
        TopAppBar(
            title = { Text(text = titleText) },
            backgroundColor = MaterialTheme.colors.primary,
            navigationIcon = {
                IconButton(onClick = {
                    navigationAction()
                }) {
                    Icon(imageVector = navigationIcon, contentDescription = "")
                }
            }
        )
    } else {
        TopAppBar(
            title = { Text(text = titleText) },
            backgroundColor = MaterialTheme.colors.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomAppBarPreview() {
    Coffee_coders_composeTheme {
        CustomAppBar(
            title = "Coffe4Coders"
        )
    }
}
