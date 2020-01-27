package com.example.waluty.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.waluty.R
import com.example.waluty.model.Currency

class CurrencyAdapter(private var currency:List<Currency>, private var date:String, val context: Context):RecyclerView.Adapter<CurrencyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currency.size
    }

    override fun onBindViewHolder(parent: MyViewHolder, position: Int) {
        val currency = currency[position]
        parent.textViewCurrencyZl.text = currency.mid.toString()
        parent.textViewshortcut.text = currency.code
        parent.textViewName.text = currency.currency
        parent.textViewDate.text = date

        //dodałem tworzenie nowej aktywnosci
        parent.itemView.setOnClickListener{
            val intent = Intent(context,checkDays::class.java)
            intent.putExtra("zl",currency.mid.toString())
            intent.putExtra("code",currency.code)
            intent.putExtra("currency",currency.currency)
            intent.putExtra("date",date)
            ContextCompat.startActivity(context, intent, null)
        }
    }

    fun update(data:List<Currency>){
        currency = data
        notifyDataSetChanged()
    }
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textViewName:TextView = view.findViewById(R.id.currency_name)
        val textViewCurrencyZl:TextView = view.findViewById(R.id.currency_kurs)
        val textViewshortcut:TextView = view.findViewById(R.id.shortcut_check)
        val textViewDate:TextView = view.findViewById(R.id.date_check)
    }
}