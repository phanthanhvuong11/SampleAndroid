package com.example.sharedpreferences.model

class User(
    private var id: Int,
    private var name: String,
    private var address: String
) {
    override fun toString(): String {
        return "User(id = $id\n Name = $name\n Address = $address"
    }
}