package com.example.waluty.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyRepository:CurrencyDataSource {

    private var call:Call<List<CurrencyResponse>>?=null

    override fun retrieveCurrency(callback: LinkStatus) {
        call=API_object.build().currencies()
        call?.enqueue(object :Callback<List<CurrencyResponse>>{
            override fun onFailure(call: Call<List<CurrencyResponse>>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(call: Call<List<CurrencyResponse>>, response: Response<List<CurrencyResponse>>) {
                response?.body()?.let {
                    if(response.isSuccessful){
                        //callbeack obiekt nasz przesyla do view modelu
                        callback.onSuccess(it[0].rates)
                        callback.onSuccess(it[0].effectiveDate)
                    }else{
                        callback.onError("Wystąpił błąd")
                    }
                }
            }
        })
    }

    override fun cancel() {
        call?.let {
            it.cancel()
        }
    }
}