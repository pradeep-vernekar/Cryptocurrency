package com.example.cryptocurrency

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
import com.example.cryptocurrency.presentation.coin_details.CoinDetailsScreen
import com.example.cryptocurrency.presentation.coin_listing.CoinListingScreen
import com.example.cryptocurrency.presentation.utils.Screen
import com.example.cryptocurrency.presentation.ui.theme.CryptocurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CryptocurrencyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route ) {
                        composable(route = Screen.CoinListScreen.route){
                            CoinListingScreen(navController = navController)
                        }
                        composable(route = Screen.CoinDetailScreen.route+"?coinId={coinId}",
                            arguments = listOf(
                                navArgument("coinId"){
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ){ navBackStack ->
                            val coinId = navBackStack.arguments?.getString("coinId")?:""
                            CoinDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptocurrencyTheme {
        Greeting("Android")
    }
}