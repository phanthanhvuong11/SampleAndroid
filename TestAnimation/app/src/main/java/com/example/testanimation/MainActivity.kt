package com.example.testanimation

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paperOnboardingFragment = PaperOnboardingFragment.newInstance(getPaperOnboardingPageData())
        val fragment = supportFragmentManager.beginTransaction()
        fragment.add(R.id.contentFrame, paperOnboardingFragment).commit()


        //   setContentView(R.layout.onboarding_main_layout)

//        val engine = PaperOnboardingEngine(findViewById(R.id.onboardingRootView),
//                getPaperOnboardingPageData(),
//                this)
//        engine.setOnChangeListener { p0, p1 ->
//            Toast.makeText(this@MainActivity,
//                    "Swiped from $p0 to $p1",
//                    Toast.LENGTH_SHORT).show()
//        }
//        engine.setOnRightOutListener {
//            Toast.makeText(this@MainActivity,
//                    "Swiped right",
//                    Toast.LENGTH_SHORT).show()
//        }
//        engine.setOnLeftOutListener {
//            Toast.makeText(this@MainActivity,
//                    "Swiped left",
//                    Toast.LENGTH_SHORT).show()
//        }
    }

    private fun getPaperOnboardingPageData(): ArrayList<PaperOnboardingPage> {
        val scr1 = PaperOnboardingPage("Hotels",
                "All hotels and hostels are sorted by hospitality rating",
                Color.parseColor("#678FB4"), R.drawable.hotels, R.drawable.key)
        val scr2 = PaperOnboardingPage("Banks",
                "We carefully verify all banks before add them into the app",
                Color.parseColor("#65B0E5"), R.drawable.banks, R.drawable.wallet)
        val scr3 = PaperOnboardingPage("Stores",
                "All local stores are categorized for your convenience",
                Color.parseColor("#9B90BC"), R.drawable.stores, R.drawable.shopping_carts)

        val elements: ArrayList<PaperOnboardingPage> = ArrayList()
        elements.add(scr1)
        elements.add(scr2)
        elements.add(scr3)
        return elements
    }
}