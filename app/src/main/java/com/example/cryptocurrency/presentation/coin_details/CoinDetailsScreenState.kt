package com.example.cryptocurrency.presentation.coin_details

import com.example.cryptocurrency.domain.entities.CoinDetail

data class CoinDetailsScreenState(
    val coinDetail:CoinDetail? = null,
    val isLoading:Boolean = false,
    val error:String = ""
)
