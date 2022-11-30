package com.transcard.coffe_coders_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.transcard.coffe_coders_compose.ui.components.CountryISO
import com.transcard.coffe_coders_compose.ui.screens.CheckoutScreen
import com.transcard.coffe_coders_compose.ui.screens.DetailScreen
import com.transcard.coffe_coders_compose.ui.screens.FeedScreen
import com.transcard.coffe_coders_compose.ui.theme.Coffee_coders_composeTheme
import com.transcard.coffe_coders_compose.utils.MockDataProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost()
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    Coffee_coders_composeTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController,
                startDestination = "feed"
            ){
                composable(route = "feed") {
                    FeedScreen(navController)
                }
                composable(
                    route = "detail/{productId}",
                    arguments = listOf(navArgument("productId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                    DetailScreen(navController, productId)
                }
                composable(
                    route = "checkout/{productId}",
                    arguments = listOf(navArgument("productId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                    CheckoutScreen(navController, productId)
                }
            }
        }
    }
}