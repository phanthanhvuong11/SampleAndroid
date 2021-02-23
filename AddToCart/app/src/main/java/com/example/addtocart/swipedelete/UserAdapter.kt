package com.example.addtocart.swipedelete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chauthai.swipereveallayout.SwipeRevealLayout
import com.chauthai.swipereveallayout.ViewBinderHelper
import com.example.addtocart.R

class UserAdapter(private var mutableList: MutableList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var viewBinderHelper: ViewBinderHelper = ViewBinderHelper()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binData()
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val swipeLayout: SwipeRevealLayout = itemView.findViewById(R.id.swipeLayout)
        private val llDelete: LinearLayout = itemView.findViewById(R.id.llDelete)
        private val tvUsername: TextView = itemView.findViewById(R.id.tvUsername)

        fun binData() {
            mutableList[adapterPosition].let {
                viewBinderHelper.bind(swipeLayout, it.id.toString())
                tvUsername.text = it.username

                llDelete.setOnClickListener {
                    mutableList.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                }
            }
        }
    }
}