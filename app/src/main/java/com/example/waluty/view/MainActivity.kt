package com.example.waluty.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waluty.R
import com.example.waluty.model.Currency
import com.example.waluty.model.Inject
import com.example.waluty.viewmodel.CurrencyViewFactory
import com.example.waluty.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //zadeklarowanie adapteru do recyclerView
    private lateinit var adapter: CurrencyAdapter
    private lateinit var viewModel: CurrencyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupUI()
    }

    private fun setupUI(){
        adapter = CurrencyAdapter(viewModel.currency.value?: emptyList())
        recyclerView.adapter= adapter
        recyclerView.layoutManager= LinearLayoutManager(this)
    }

    private  fun setupViewModel(){
        viewModel = ViewModelProvider(this,CurrencyViewFactory(Inject.providerRepository())).get(CurrencyViewModel::class.java)
        viewModel.currency.observe(this,renderCurrencies)

        viewModel.isViewLoading.observe(this,isViewLoadingObserver)

    }

    private val renderCurrencies= Observer<List<Currency>> {
        adapter.update(it)
    }

    private val isViewLoadingObserver= Observer<Boolean> {
        val visibility=if(it) View.VISIBLE else View.GONE
        //progressBar.visibility= visibility
    }





    override fun onResume() {
        super.onResume()
        viewModel.loadCurrencies()
    }
}
