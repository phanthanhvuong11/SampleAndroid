package com.example.testanimation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testanimation.R
import com.example.testanimation.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(private var mutableList: MutableList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    fun setData(mutableList: MutableList<User>) {
        this.mutableList = mutableList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binData()

    }

    override fun getItemCount(): Int = mutableList.size

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvName = itemView.tvName

        @SuppressLint("SetTextI18n")
        fun binData() {
            mutableList[adapterPosition].let {
                tvName.text = it.name + " " + (adapterPosition + 1)
            }
        }
    }
}