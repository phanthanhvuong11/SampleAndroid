package com.example.testanimation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testanimation.fragment.FavoriteFragment
import com.example.testanimation.fragment.HomeFragment
import com.example.testanimation.fragment.MyPageFragment

class MyViewPager2Adapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment.newInstance()
            1 -> FavoriteFragment.newInstance()
            2 -> MyPageFragment.newInstance()
            else -> MyPageFragment.newInstance()
        }
    }
}