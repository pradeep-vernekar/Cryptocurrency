package com.example.cryptocurrency.domain.repository

import com.example.cryptocurrency.domain.entities.Coin
import com.example.cryptocurrency.domain.entities.CoinDetail

interface CurrencyRepository {
    suspend fun getCoin():List<Coin>
    suspend fun getCoinDetails(name:String):CoinDetail
}