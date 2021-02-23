package com.example.testanimation

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.testanimation.adapter.MyViewPager2Adapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_view_pager_and_navigation_bottom.*

class ViewPagerAndNavigationBottom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_and_navigation_bottom)
        viewPager2.apply {
            adapter = MyViewPager2Adapter(this@ViewPagerAndNavigationBottom)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            viewPager2.setPageTransformer(DepthPageTransformer())
        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> bottomNavigation.menu.findItem(R.id.menuHome).isChecked = true
                    1 -> bottomNavigation.menu.findItem(R.id.menuFavorite).isChecked = true
                    2 -> bottomNavigation.menu.findItem(R.id.menuPage).isChecked = true
                }
            }
        })
        bottomNavigation.setOnNavigationItemReselectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener,
            BottomNavigationView.OnNavigationItemReselectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.menuHome -> viewPager2.currentItem = 0
                    R.id.menuFavorite -> viewPager2.currentItem = 1
                    R.id.menuPage -> viewPager2.currentItem = 2
                }
                return true
            }

            override fun onNavigationItemReselected(item: MenuItem) {
                TODO("Not yet implemented")
            }


        })
    }
}