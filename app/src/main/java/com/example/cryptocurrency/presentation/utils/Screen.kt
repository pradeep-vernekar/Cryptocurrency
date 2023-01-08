package com.example.cryptocurrency.presentation.utils

sealed class Screen(val route:String){
    object CoinListScreen:Screen(route = "coin_listing_screen")
    object CoinDetailScreen:Screen(route = "coin_details_screen")
}
