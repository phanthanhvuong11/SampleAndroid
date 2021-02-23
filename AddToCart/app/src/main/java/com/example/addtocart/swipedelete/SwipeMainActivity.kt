package com.example.addtocart.swipedelete

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.addtocart.R
import kotlinx.android.synthetic.main.activity_swipe_main.*

class SwipeMainActivity : AppCompatActivity() {
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_main)

        initViews()
    }

    fun initViews() {
        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        userAdapter = UserAdapter(getListUser())
        recyclerView.adapter = userAdapter

        var dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    private fun getListUser(): MutableList<User> {
        var mutableList: MutableList<User> = mutableListOf()

        for (i in 1..20) {
            mutableList.add(User(i, "User name $i"))
        }
        return mutableList
    }
}