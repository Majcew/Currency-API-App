package com.example.waluty.model

object Inject{

    //MuseumRepository może byc singletonem (tak na przyszłość)
    fun providerRepository():CurrencyDataSource{
        return CurrencyRepository()
    }
}