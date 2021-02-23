package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import java.util.*

class MySharedPreferences(private var context: Context) {
    companion object {
        const val MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES"

    }

    fun putBooleanValue(key: String, value: Boolean) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            MY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )
        val sharedPreferencesEditor = sharedPreferences.edit()

        sharedPreferencesEditor.putBoolean(key, value)
        sharedPreferencesEditor.apply()
    }

    fun getBooleanValue(key: String): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            MY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )
        return sharedPreferences.getBoolean(key, false)
    }

    fun putStringValue(key: String, value: String) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            MY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )
        val sharedPreferencesEditor = sharedPreferences.edit()

        sharedPreferencesEditor.putString(key, value)
        sharedPreferencesEditor.apply()
    }

    fun getStringValue(key: String): String {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            MY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(key, "false").toString()
    }


    fun putStringSetValue(key: String, value: Set<String>) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            MY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )
        val sharedPreferencesEditor = sharedPreferences.edit()

        sharedPreferencesEditor.putStringSet(key, value)
        sharedPreferencesEditor.apply()
    }

    fun getStringSetValue(key: String): MutableSet<String>? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            MY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )
        val valueDefault = HashSet<String>();
        return sharedPreferences.getStringSet(key, valueDefault)
    }
}