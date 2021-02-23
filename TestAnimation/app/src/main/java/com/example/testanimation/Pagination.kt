package com.example.testanimation

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testanimation.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_pagination.*

class Pagination : AppCompatActivity() {

    private val exampleLists: MutableList<User> = mutableListOf()
    private var adapterRecycler = UserAdapter(exampleLists)
    private var listUser: MutableList<User> = mutableListOf()

    var isLoad: Boolean = false
    var isLast: Boolean = false
    private var currentPage = 1
    private var totalPage = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagination)
        initView()
    }

    private fun initView() {
        //recyclerViewUser.adapter = adapterRecycler
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerViewUser.layoutManager = linearLayoutManager
        recyclerViewUser.setHasFixedSize(true)

//        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
//        recyclerViewUser.addItemDecoration(itemDecoration)
        recyclerViewUser.addOnScrollListener(object :
            PaginationScrollListener(linearLayoutManager) {
            override fun loadMoreItem() {
                isLoad = true
                progressBarLoad.visibility = View.VISIBLE
                currentPage += 1
                loadNextPage()
            }

            override var isLastPage: Boolean
                get() = isLast
                set(value) {}
            override var isLoading: Boolean
                get() = isLoad
                set(value) {}
        })
        setFirstData()
    }

    private fun setFirstData() {
        listUser = getListUser()
        adapterRecycler.setData(listUser)
        recyclerViewUser.adapter = adapterRecycler
    }

    private fun getListUser(): MutableList<User> {
        Toast.makeText(this, "Load data page $currentPage", Toast.LENGTH_SHORT).show()
        val list = mutableListOf<User>()
        for (i in 1..10) {
            list.add(User("User Name"))
        }
        return list
    }

    private fun loadNextPage() {
        Handler().postDelayed({
            val list = getListUser()
            listUser.addAll(list)
            adapterRecycler.notifyDataSetChanged()

            isLoad = false
            progressBarLoad.visibility = View.GONE
            if (currentPage == totalPage) {
                isLast = true
            }
        }, 2000)
    }
}