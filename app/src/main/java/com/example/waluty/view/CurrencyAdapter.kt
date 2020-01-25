package com.example.waluty.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.waluty.R
import com.example.waluty.model.Currency

class CurrencyAdapter(private var currency:List<Currency>):RecyclerView.Adapter<CurrencyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currency.size
    }

    override fun onBindViewHolder(parent: MyViewHolder, position: Int) {
        val currency = currency[position]
        parent.textViewCurrencyZl.text = currency.price.toString()
        parent.textViewDate.text = currency.code
        parent.textViewName.text = currency.name
    }

    fun update(data:List<Currency>){
        currency = data
        notifyDataSetChanged()
    }
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textViewName:TextView = view.findViewById(R.id.currency_name)
        val textViewCurrencyZl:TextView = view.findViewById(R.id.currency_kurs)
        val textViewDate:TextView = view.findViewById(R.id.date)
    }
}