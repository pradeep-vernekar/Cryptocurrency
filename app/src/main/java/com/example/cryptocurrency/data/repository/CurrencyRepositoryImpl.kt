package com.example.cryptocurrency.data.repository

import com.example.cryptocurrency.data.mapper.toDomain
import com.example.cryptocurrency.data.source.remote.ApiServices
import com.example.cryptocurrency.domain.entities.Coin
import com.example.cryptocurrency.domain.entities.CoinDetail
import com.example.cryptocurrency.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val apiServices: ApiServices
) : CurrencyRepository {

    override suspend fun getCoin(): List<Coin> {
        return apiServices.getCoins().map {
            it.toDomain()
        }
    }

    override suspend fun getCoinDetails(name: String): CoinDetail {
        return apiServices.getCoinDetail(name).toDomain()
    }
}