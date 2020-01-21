package com.example.waluty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.waluty.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //zadeklarowanie adapteru do recyclerView
    private lateinit var adapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI(){
        adapter = CurrencyAdapter()
        recyclerView.adapter = adapter
    }
}
