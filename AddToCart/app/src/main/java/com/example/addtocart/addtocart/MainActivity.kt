package com.example.addtocart.addtocart

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.aurelhubert.ahbottomnavigation.notification.AHNotification
import com.example.addtocart.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var imgAnimation: ImageView
    lateinit var viewEndAnimation: View
    var mCountProduct: Int = 0
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgAnimation = findViewById(R.id.imgAnimation)
        viewEndAnimation = findViewById(R.id.viewEndAnimation)
        viewPagerAdapter = ViewPagerAdapter(
            supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        ahBottomNavigationViewPager.adapter = viewPagerAdapter
        ahBottomNavigationViewPager.setPagingEnabled(true)
        initView()

    }

    private fun initView() {
        val item1 = AHBottomNavigationItem(
            R.string.tab_1,
            R.drawable.ic_baseline_apps_24,
            R.color.color_tab_1
        )
        val item2 = AHBottomNavigationItem(
            R.string.tab_2,
            R.drawable.ic_baseline_add_shopping_cart_24,
            R.color.color_tab_2
        )
        val item3 = AHBottomNavigationItem(
            R.string.tab_3,
            R.drawable.ic_baseline_notifications_active_24,
            R.color.color_tab_3
        )

        ahBottomNavigation.addItem(item1)
        ahBottomNavigation.addItem(item2)
        ahBottomNavigation.addItem(item3)

        ahBottomNavigation.setOnTabSelectedListener { position, _ ->
            ahBottomNavigationViewPager.currentItem = position
            true
        }
        ahBottomNavigationViewPager.addOnPageChangeListener(object :
            ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                ahBottomNavigation.currentItem = position
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
    }

    fun setCountProductInCart(count: Int) {
        mCountProduct = count
        val notification = AHNotification.Builder()
            .setText(count.toString())
            .setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    android.R.color.holo_red_dark
                )
            )
            .setTextColor(
                ContextCompat.getColor(
                    this,
                    android.R.color.white
                )
            )
            .build()
        ahBottomNavigation.setNotification(notification, 1)
    }
}