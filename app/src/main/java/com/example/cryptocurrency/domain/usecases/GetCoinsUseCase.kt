package com.example.cryptocurrency.domain.usecases

import com.example.cryptocurrency.common.Response
import com.example.cryptocurrency.domain.entities.Coin
import com.example.cryptocurrency.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {

    operator fun invoke():Flow<Response<List<Coin>>> = flow {
        emit(Response.Loading())
        try {
            val response = repository.getCoin()
            emit(Response.Success(data = response))
        }catch (e:Exception){
            emit(Response.Failure(message = e.message.toString()))
        }
    }
}