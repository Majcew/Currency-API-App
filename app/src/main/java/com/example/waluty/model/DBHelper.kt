package com.example.waluty.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DBHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        internal const val DATABASE_VERSION = 1
        internal const val DATABASE_NAME = "Currency.db"
        internal const val TABLE_NAME = "currency"
        internal const val COL_CURRENCY = "name"
        internal const val COL_CODE = "code"
        internal const val COL_MID = "mid"
        internal const val COL_DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = db!!.execSQL(
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                    "$COL_CURRENCY TEXT NOT NULL, " +
                    "$COL_CODE TEXT NOT NULL, " +
                    "$COL_MID DOUBLE NOT NULL, " +
                    "$COL_DATE TEXT NOT NULL)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    val allCurrency: MutableList<ConcreteValue>

        get() {
            val query = "SELECT * FROM $TABLE_NAME"
            val currencyy = mutableListOf<ConcreteValue>()
            val db = this.writableDatabase
            val cursor = db.rawQuery(query, null)

            if (cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndex(COL_CURRENCY))
                    val code = cursor.getString(cursor.getColumnIndex(COL_CODE))
                    val mid = cursor.getDouble(cursor.getColumnIndex(COL_MID))
                    val date = cursor.getString(cursor.getColumnIndex(COL_DATE))

                    val concreteValue = ConcreteValue(name, code, mid,date)
                    currencyy.add(concreteValue)

                } while (cursor.moveToNext())

            }
            db.close()
            return currencyy
        }
    fun neededCurrency(code:String):List<ConcreteValue>
    {
        val query = "SELECT * FROM $TABLE_NAME WHERE $COL_CODE LIKE '$code'"
        val currencyy = mutableListOf<ConcreteValue>()
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val name = cursor.getString(cursor.getColumnIndex(COL_CURRENCY))
                val code = cursor.getString(cursor.getColumnIndex(COL_CODE))
                val mid = cursor.getDouble(cursor.getColumnIndex(COL_MID))
                val date = cursor.getString(cursor.getColumnIndex(COL_DATE))

                val concreteValue = ConcreteValue(name, code, mid,date)
                currencyy.add(concreteValue)

            } while (cursor.moveToNext())

        }
        db.close()
        return currencyy
    }

    fun addCurrency(currency: Currency,date:String) {
        val db = this.writableDatabase

            val value = contentValuesOf()
                value.put(COL_CURRENCY, currency.currency)
                value.put(COL_CODE, currency.code)
                value.put(COL_MID, currency.mid.toString())
                value.put(COL_DATE, date)
                db.insert(TABLE_NAME, null, value)
            db.close()
    }


    fun CheckIfDataAlreadyInDBorNot(currency: List<Currency>, date: String) {
        for (i in 0..currency.size - 1) {
            var code = currency[i].code
            val db = this.writableDatabase
            val query = "SELECT * FROM $TABLE_NAME WHERE $COL_CODE = '$code' AND $COL_DATE = '$date'"
            val cursor = db.rawQuery(query, null)
            if (cursor.count <= 0) {
                cursor.close()
                addCurrency(currency[i], date)
            }
            cursor.close()
        }
        return
    }

}