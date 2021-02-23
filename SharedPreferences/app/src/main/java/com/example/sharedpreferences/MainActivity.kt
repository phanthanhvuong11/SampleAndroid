package com.example.sharedpreferences

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferences.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (DataLocalManager.getFirstInstall() == false) {
//            Toast.makeText(this, "First Install App", Toast.LENGTH_LONG).show()
//            DataLocalManager.setFirstInstall(true)
//        }
//        val nameUser = HashSet<String>()
//        nameUser.add("TinCoder")
//        nameUser.add("thanh vuong")
//        nameUser.add("van anh")
//
//        DataLocalManager.setNameUsers(nameUser)
        val user1 = User(1, "Thanh Vuong", "Thanh Xuan, Ha Noi")
        val user2 = User(2, "Thanh ", "Thanh Xuan, Ha Noi")
        val listUser = mutableListOf<User>()
        listUser.add(user1)
        listUser.add(user2)
        DataLocalManager().setListUser(listUser)

        btnNextScreen.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}