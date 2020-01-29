package com.example.waluty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.waluty.R
import com.example.waluty.model.DBHelper
import kotlinx.android.synthetic.main.check_layout.*
import kotlinx.android.synthetic.main.check_layout.date_check
import kotlinx.android.synthetic.main.check_layout.shortcut_check
import kotlinx.android.synthetic.main.currency_layout.*

class checkDays : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.check_layout)

        val intent = intent
        val mid = intent.getStringExtra("zl")
        val code = intent.getStringExtra("code")
        val currency = intent.getStringExtra("currency")
        val date = intent.getStringExtra("date")
        val db = DBHelper(this)
        val kupa = db.neededCurrency(code)
        currency_name_check.setText(kupa[0].name)
        date_check.setText(kupa[0].date)
        currency_kurs_check.setText(kupa[0].mid.toString())
        shortcut_check.setText(kupa[0].code)
    }
}
