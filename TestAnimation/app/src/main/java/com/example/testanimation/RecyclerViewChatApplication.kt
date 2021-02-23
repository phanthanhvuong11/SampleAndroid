package com.example.testanimation

import android.graphics.Rect
import android.os.Bundle
import android.text.TextUtils
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testanimation.adapter.MessageAdapter
import kotlinx.android.synthetic.main.activity_recycler_view_chat_application.*

class RecyclerViewChatApplication : AppCompatActivity() {
    private val exampleLists: MutableList<Message> = mutableListOf()
    private var adapterRecycler = MessageAdapter(exampleLists)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_chat_application)
        initView()
    }

    private fun initView() {
        recyclerViewMessage.adapter = adapterRecycler
        recyclerViewMessage.layoutManager = LinearLayoutManager(this)
        recyclerViewMessage.setHasFixedSize(true)

        btnSend?.setOnClickListener { sendMessage() }
        edtMessage?.setOnClickListener { checkKeyBoard() }
    }

    private fun sendMessage() {
        val message = edtMessage.text.toString().trim()
        edtMessage.run {
            if (TextUtils.isEmpty(message)) {
                return
            }
            exampleLists.add(Message(message))
            adapterRecycler.notifyDataSetChanged()
            recyclerViewMessage.scrollToPosition(exampleLists.size - 1)
            edtMessage.setText("")
        }
    }

    private fun checkKeyBoard() {
        activityRootView.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val rect = Rect()
                activityRootView.getWindowVisibleDisplayFrame(rect)
                val heightDiff = activityRootView.rootView.height - rect.height()
                if (heightDiff > 0.25 * activityRootView.rootView.height) {
                    if (exampleLists.size > 0) {
                        recyclerViewMessage.scrollToPosition(exampleLists.size - 1)
                        activityRootView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    }
                }
            }

        })
    }
}