package com.example.sharedpreferences

import android.content.Context
import com.example.sharedpreferences.model.User
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class DataLocalManager {
    private var mySharedPreferences: MySharedPreferences? = null

    companion object {
        private const val PREF_FIRST_INSTALL = "PREF_FIRST_INSTALL"
        private const val PREF_NAME_USER = "PREF_NAME_USER"
        private const val PREF_OBJECT_USER = "PREF_OBJECT_USER"
        private const val PREF_LIST_OBJECT_USER = "PREF_LIST_OBJECT_USER"
        private var instance: DataLocalManager? = null
        private fun getInstance(): DataLocalManager? {
            if (instance == null) {
                instance = DataLocalManager()
            }
            return instance
        }
    }

    fun init(context: Context?) {
        instance = DataLocalManager()
        instance?.mySharedPreferences = context?.let { MySharedPreferences(it) }
    }


    fun setFirstInstall(isFirst: Boolean) {
        getInstance()?.mySharedPreferences?.putBooleanValue(
            PREF_FIRST_INSTALL,
            isFirst
        )
    }

    fun getFirstInstall(): Boolean? {
        return getInstance()?.mySharedPreferences?.getBooleanValue(
            PREF_FIRST_INSTALL
        )
    }

    fun setNameUsers(nameUsers: Set<String>) {
        getInstance()?.mySharedPreferences?.putStringSetValue(
            PREF_NAME_USER,
            nameUsers
        )
    }

    fun getNameUsers(): MutableSet<String>? {
        return getInstance()?.mySharedPreferences?.getStringSetValue(
            PREF_NAME_USER
        )
    }

    fun setUser(user: User) {
        val gson = Gson()
        val jsonUser = gson.toJson(user)
        getInstance()?.mySharedPreferences?.putStringValue(
            PREF_OBJECT_USER,
            jsonUser
        )
    }

    fun getUser(): User {
        val jsonUser = getInstance()?.mySharedPreferences?.getStringValue(
            PREF_OBJECT_USER
        )
        val gson = Gson()
        return gson.fromJson(jsonUser, User::class.java)
    }

    fun setListUser(listUser: List<User>) {
        val gson = Gson()
        val jsonArray = gson.toJsonTree(listUser).asJsonArray
        val strJsonArray = jsonArray.toString()
        getInstance()?.mySharedPreferences?.putStringValue(
            PREF_LIST_OBJECT_USER, strJsonArray
        )
    }

    fun getListUser(): List<User> {
        val strJsonArray = getInstance()?.mySharedPreferences?.getStringValue(
            PREF_LIST_OBJECT_USER
        )
        val listUser = mutableListOf<User>()
        val jsonArray = JSONArray(strJsonArray)
        var jsonObject: JSONObject
        val gson = Gson()

        var user: User

        for (i in 0 until jsonArray.length()) {
            jsonObject = jsonArray.getJSONObject(i)
            user = gson.fromJson(jsonObject.toString(), User::class.java)
            listUser.add(user)
        }
        return listUser
    }
}