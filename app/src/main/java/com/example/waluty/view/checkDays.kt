package com.example.waluty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.waluty.R
import kotlinx.android.synthetic.main.check_layout.*
import kotlinx.android.synthetic.main.check_layout.date_check
import kotlinx.android.synthetic.main.check_layout.shortcut_check
import kotlinx.android.synthetic.main.currency_layout.*

class checkDays : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_days)

        val intent = intent
        val mid = intent.getStringExtra("zl")
        val code = intent.getStringExtra("code")
        val currency = intent.getStringExtra("currency")
        val date = intent.getStringExtra("date")

        currency_name_check.setText(currency)
        date_check.setText(date)
        currency_kurs.setText(mid)
        shortcut_check.setText(code)
    }
}
