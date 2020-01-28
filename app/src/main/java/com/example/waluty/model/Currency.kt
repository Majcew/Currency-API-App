package com.example.waluty.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Currency(
    @SerializedName("currency")
    val currency:String,
    @SerializedName("code")
    val code:String,
    @SerializedName("mid")
    val mid:Double):Serializable