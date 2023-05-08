package com.jalian.blackbook

import android.content.Context
import android.content.SharedPreferences

class SharePreferenceManager(private val context: Context, private val tableName: String) {

    private fun getSharePreference() : SharedPreferences {
        return context.getSharedPreferences(tableName, Context.MODE_PRIVATE)
    }

    fun getString(key : String, defaultValue: String ) : String? {
        return getSharePreference().getString(key, defaultValue)
    }

    fun getInt(key: String, defaultValue: Int) : Int? {
        return getSharePreference().getInt(key, defaultValue)
    }

    fun getBoolean(key: String, defaultValue: Boolean) : Boolean?{
        return getSharePreference().getBoolean(key,defaultValue)
    }

    fun putString(key : String, value : String){
        val editor = getSharePreference().edit()
        editor.putString(key,value)
        editor.apply()
    }

    fun putInt(key: String, value: Int){
        val editor = getSharePreference().edit()
        editor.putInt(key,value)
        editor.apply()
    }

    fun putBoolean(key: String, value: Boolean){
        val editor = getSharePreference().edit()
        editor.putBoolean(key,value)
        editor.apply()
    }

    fun remove(key: String){
        val editor = getSharePreference().edit()
        editor.remove(key)
        editor.apply()
    }
}