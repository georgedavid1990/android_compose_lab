package com.transcard.coffe_coders_compose.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.transcard.coffe_coders_compose.ui.components.BodyText
import com.transcard.coffe_coders_compose.ui.components.CountryISO
import com.transcard.coffe_coders_compose.ui.components.ProductCard
import com.transcard.coffe_coders_compose.ui.components.TitleText
import com.transcard.coffe_coders_compose.ui.theme.Coffee_coders_composeTheme
import com.transcard.coffe_coders_compose.utils.MockDataProvider

@Composable
fun FeedScreen(navController: NavController){

    val products = MockDataProvider.getListOfProducts()

    Coffee_coders_composeTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)){
                item { 
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        TitleText(title = "Bienvenido")
                        BodyText(text = "Get crypto analysis, news and updates right to your inbox! Sign up here so you don't miss a single newsletter.")
                    }
                }

                items(products) { p ->
                    ProductCard(product = p) {
                        navController.navigate("detail/${p.id}"){
                            launchSingleTop = true //If it is already presented, do not show
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview(){
    val navController = rememberNavController()
    Coffee_coders_composeTheme {
        FeedScreen(navController)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FeedScreenDarkPreview(){
    val navController = rememberNavController()
    Coffee_coders_composeTheme {
        FeedScreen(navController)
    }
}