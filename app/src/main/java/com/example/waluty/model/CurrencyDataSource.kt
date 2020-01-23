package com.example.waluty.model

interface CurrencyDataSource {

    fun retrieveCurrency()
    fun cancel()
}