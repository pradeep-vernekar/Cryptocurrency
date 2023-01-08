package com.example.cryptocurrency.data.source.remote

import com.example.cryptocurrency.data.model.CoinDetailDto
import com.example.cryptocurrency.data.model.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("coins")
    suspend fun getCoins():List<CoinDto>

    @GET("coins/{name}")
    suspend fun getCoinDetail(
        @Path("name") name:String
    ):CoinDetailDto
}