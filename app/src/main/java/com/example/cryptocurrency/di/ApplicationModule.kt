package com.example.cryptocurrency.di

import com.example.cryptocurrency.common.Constants
import com.example.cryptocurrency.data.repository.CurrencyRepositoryImpl
import com.example.cryptocurrency.data.source.remote.ApiServices
import com.example.cryptocurrency.domain.repository.CurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiServices(retrofit: Retrofit):ApiServices{
        return retrofit.create(ApiServices::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(apiServices: ApiServices):CurrencyRepository{
        return CurrencyRepositoryImpl(apiServices)
    }
}