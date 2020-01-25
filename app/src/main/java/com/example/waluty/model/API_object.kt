package com.example.waluty.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object API_object {
    private const val API_BASE_URL = "https://api.nbp.pl/api/"
    private var servicesApiInterface:ServicesApiInterface?=null

    fun build():ServicesApiInterface
    {
            var builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

            var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            httpClient.addInterceptor(interceptor())

            var retrofit: Retrofit = builder.client(httpClient.build()).build()
            servicesApiInterface = retrofit.create(
                ServicesApiInterface::class.java)

            return servicesApiInterface as ServicesApiInterface
    }

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    interface ServicesApiInterface{
        @GET("exchangerates/tables/a/?format=json")
        fun currencies(): Call<List<CurrencyResponse>>
    }
}