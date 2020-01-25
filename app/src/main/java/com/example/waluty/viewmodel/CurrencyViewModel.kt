package com.example.waluty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waluty.model.Currency
import com.example.waluty.model.CurrencyDataSource
import com.example.waluty.model.LinkStatus

class CurrencyViewModel(private val repository: CurrencyDataSource):ViewModel() {
    private val _currency = MutableLiveData<List<Currency>>().apply { value = emptyList() }
    val currency:LiveData<List<Currency>> = _currency

    private val _onMessageError=MutableLiveData<Any>()

    private val _isEmptyList=MutableLiveData<Boolean>()

    fun loadCurrencies(){
        repository.retrieveCurrency(object:LinkStatus{
            override fun onError(obj: Any?) {
                _onMessageError.postValue(obj) //obiekt który tutaj otrzymuje jest wiadomością typu error zamiast tablicą json
                //a wiec onError(obj) dobrze działa, zrobić odpowiednie zmiany, żeby retrofit poprawnie pobierał dane i przypisywał do listy
            }

            override fun onSuccess(obj: Any?) {

                if(obj!=null && obj is List<*>){
                    if(obj.isEmpty()){
                        _isEmptyList.postValue(true)
                    }else{
                        _currency.value= obj as List<Currency>
                    }
                }
            }
        })
    }

}