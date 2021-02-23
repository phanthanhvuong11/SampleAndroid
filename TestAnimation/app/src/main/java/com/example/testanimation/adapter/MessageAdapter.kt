package com.example.testanimation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testanimation.Message
import com.example.testanimation.R
import kotlinx.android.synthetic.main.item_message.view.*

class MessageAdapter(private var mutableList: MutableList<Message>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    fun setData(mutableList: MutableList<Message>){
        this.mutableList = mutableList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.binData()

    }

    override fun getItemCount(): Int = mutableList.size

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvMessage = itemView.tvMessage
        fun binData(){
            mutableList[adapterPosition].let {
                tvMessage.text = it.message
            }
        }
    }
}