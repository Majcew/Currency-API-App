package com.example.waluty.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.waluty.R
import java.util.*

class CurrencyAdapter(private var currency:List<Currency>):RecyclerView.Adapter<CurrencyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currency.size
    }

    override fun onBindViewHolder(parent: MyViewHolder, position: Int) {
        val currenc = currency[position]
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textViewName:TextView = view.findViewById(R.id.currency_name)
        val textViewCurrencyZl:TextView = view.findViewById(R.id.curency_zl)
        val textViewDate:TextView = view.findViewById(R.id.currency_date)
    }
}