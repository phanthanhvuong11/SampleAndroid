package com.example.sharedpreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferences.model.User

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val user = User(1, "Thanh Vuong", "Thanh Xuan, Ha Noi")
        DataLocalManager().setUser(user)
    }
}