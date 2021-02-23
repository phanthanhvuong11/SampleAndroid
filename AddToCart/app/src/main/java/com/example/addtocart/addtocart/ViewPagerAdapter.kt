package com.example.addtocart.addtocart

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Int) :
    FragmentStatePagerAdapter(fragmentManager, lifecycle) {
    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ProductFragment.newInstance()
            1 -> AddCartFragment.newInstance()
            2 -> NoticeFragment.newInstance()
            else -> ProductFragment.newInstance()
        }
    }
}