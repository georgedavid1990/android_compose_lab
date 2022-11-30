package com.transcard.coffe_coders_compose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import com.transcard.coffe_coders_compose.ui.theme.Coffee_coders_composeTheme

@Composable
fun DropDownTextField(
    suggestions: List<String>,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = Icons.Filled.ArrowDropDown
    
    Column {
        CustomTextField(
            value = value, 
            placeholder = placeholder, 
            onValueChange = onValueChange,
            enabled = false,
            trailingIcon = {
                Icon(imageVector = icon, contentDescription = "", modifier = Modifier.clickable {
                    expanded = !expanded
                })
            },
            onGloballyPositioned = { layoutCoordinates ->
                textFieldSize = layoutCoordinates.size.toSize()
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {  expanded = false },
            modifier = Modifier.width(with(LocalDensity.current){ textFieldSize.width.toDp() })
        ) {
            suggestions.forEach{ label ->
                DropdownMenuItem(onClick = { onValueChange(label) }) {
                    Text(text = label, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropDownTextFieldPreview() {
    val cities = listOf(
        "Mexico City, Mexico",
        "The Habana, Cuba",
        "Cancun, Mexico",
        "Medellin, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Panama City, Panama"
    )

    Coffee_coders_composeTheme {
        DropDownTextField(suggestions = cities, value = "", placeholder = "Ciudades"){}
    }
}