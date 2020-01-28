package com.example.waluty.model

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery




@Dao
interface CurrencyDAO
{

    /*@Query("SELECT * FROM currencies")
    fun getAll(): List<CurrencyResponse>

    @RawQuery
    fun getCurrency(query: SupportSQLiteQuery?): List<Currency>

    @Insert
    fun insertAll(vararg responses: List<CurrencyResponse>)*/


}