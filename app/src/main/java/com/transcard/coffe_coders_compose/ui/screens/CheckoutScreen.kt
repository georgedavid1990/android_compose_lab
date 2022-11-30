package com.transcard.coffe_coders_compose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.transcard.coffe_coders_compose.models.Product
import com.transcard.coffe_coders_compose.ui.components.*
import com.transcard.coffe_coders_compose.ui.theme.Coffee_coders_composeTheme
import com.transcard.coffe_coders_compose.utils.MockDataProvider

@Composable
fun CheckoutScreen(
    navController: NavController,
    productId: Int
) {
    MockDataProvider.getProductBy(productId)?.let { product ->

        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var phone by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var city by remember { mutableStateOf("") }
        var message by remember { mutableStateOf("") }

        Scaffold(
            topBar = {
                CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
                    navController.navigate(route = "detail/${product.id}")
                }
            },
            content = {

                Alert(title = "Felicidades", message = message) {
                    navController.navigate("feed"){
                        launchSingleTop = true
                        popUpTo("feed")
                    }
                }

                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    ProductCard(product) {}

                    Column(modifier = Modifier.padding(16.dp)) {
                        CustomTextField(value = name, placeholder = "Nombre") {
                            name = it
                        }
                        CustomTextField(value = email, placeholder = "Email") {
                            email = it
                        }
                        CustomTextField(value = phone, placeholder = "Teléfono") {
                            phone = it
                        }
                        CustomTextField(value = address, placeholder = "Dirección") {
                            address = it
                        }
                        DropDownTextField(suggestions = MockDataProvider.getCities(), value = city, placeholder = "Ciudad"){
                            city = it
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        Column {
                            Row {
                                Text(text = "Subtotal", style = MaterialTheme.typography.caption)
                                Text(
                                    text = "$ ${product.price} ${product.currency}",
                                    style = MaterialTheme.typography.body2,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                            }
                            Row {
                                Text(text = "Envío", style = MaterialTheme.typography.caption)
                                Text(
                                    text = "$ 10.0 ${product.currency}",
                                    style = MaterialTheme.typography.body2,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            Text(
                                text = "$ ${(product.price + 10.0)} ${product.currency}",
                                style = MaterialTheme.typography.h5,
                                textAlign = TextAlign.Start
                            )
                            CustomButton(label = "Finalizar Pedido") {
                                message = "Tu pedido ha sido creado :)"
                            }
                        }
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    val navController = rememberNavController()
    Coffee_coders_composeTheme {
        CheckoutScreen(navController, 1)
    }
}