package com.example.waluty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.waluty.R
import com.example.waluty.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Collections.emptyList

class MainActivity : AppCompatActivity() {

    //zadeklarowanie adapteru do recyclerView
    private lateinit var adapter: CurrencyAdapter
    private lateinit var viewModel: CurrencyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI(){
        adapter = CurrencyAdapter( viewModel.currency.value?: emptyList())
        recyclerView.adapter = adapter
    }

    private  fun setupViewModel(){
    }
}
