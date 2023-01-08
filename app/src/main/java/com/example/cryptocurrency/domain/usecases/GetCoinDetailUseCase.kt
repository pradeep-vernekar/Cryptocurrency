package com.example.cryptocurrency.domain.usecases

import com.example.cryptocurrency.common.Response
import com.example.cryptocurrency.domain.entities.CoinDetail
import com.example.cryptocurrency.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {

    operator fun invoke(name:String):Flow<Response<CoinDetail>> = flow {
        emit(Response.Loading())
        try {
            val response = repository.getCoinDetails(name = name)
            emit(Response.Success(data = response))
        }catch (e:Exception){
            emit(Response.Failure(message = e.message.toString()))
        }
    }
}