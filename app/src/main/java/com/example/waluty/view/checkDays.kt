package com.example.waluty.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waluty.R
import com.example.waluty.model.DBHelper
import kotlinx.android.synthetic.main.activity_check_days.*

class checkDays : AppCompatActivity() {
    private lateinit var adapter : NeededCurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_days)

        val intent = intent
        val code = intent.getStringExtra("code")
        val db = DBHelper(this)
        val needed = db.neededCurrency(code)

        adapter = NeededCurrencyAdapter(needed) //jezeli jest nullem to random
        recyclerViewCheck.adapter= adapter
        recyclerViewCheck.layoutManager= LinearLayoutManager(this)

    }
}
