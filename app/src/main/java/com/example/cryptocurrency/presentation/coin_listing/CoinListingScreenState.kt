package com.example.cryptocurrency.presentation.coin_listing

import com.example.cryptocurrency.domain.entities.Coin

data class CoinListingScreenState(
    var coins:MutableList<Coin> = mutableListOf(),
    val isLoading:Boolean = false,
    val error:String = ""
)
