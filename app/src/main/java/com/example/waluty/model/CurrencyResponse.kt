package com.example.waluty.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

//data class do responsa API (nasze api jako response daje nr.partii, datę oraz listę walut)
@Entity(tableName = "currencies")
data class CurrencyResponse(
    @PrimaryKey
    val no:String?,
    @ColumnInfo(name = "date")
    val effectiveDate:String?,
    @Embedded(prefix = "rates_")
    val rates:List<Currency>?
)