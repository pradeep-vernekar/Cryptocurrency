package com.example.cryptocurrency.common

sealed class Response<T>{
    class Success<T>(val data:T):Response<T>()
    class Failure<T>(val message:String):Response<T>()
    class Loading<T>():Response<T>()
}
