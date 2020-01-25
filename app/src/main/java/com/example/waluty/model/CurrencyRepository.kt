package com.example.waluty.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyRepository:CurrencyDataSource {

    private var call:Call<CurrencyResponse>?=null

    override fun retrieveCurrency(callback: LinkStatus) {
        call=API_object.build().currencies()
        call?.enqueue(object :Callback<CurrencyResponse>{
            override fun onFailure(call: Call<CurrencyResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(call: Call<CurrencyResponse>, response: Response<CurrencyResponse>) {
                response?.body()?.let {
                    if(response.isSuccessful){
                        callback.onSuccess(it.data)
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