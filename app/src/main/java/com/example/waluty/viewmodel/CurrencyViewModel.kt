package com.example.waluty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waluty.model.CurrencyDataSource
import java.util.*
import java.util.Collections.emptyList

class CurrencyViewModel(private val repository: CurrencyDataSource):ViewModel() {

    private val _currency = MutableLiveData<List<Currency>>().apply { value = emptyList() }
    val currency:LiveData<List<Currency>> = _currency

}