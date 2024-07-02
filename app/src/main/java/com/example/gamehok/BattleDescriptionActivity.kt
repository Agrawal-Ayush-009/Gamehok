package com.example.gamehok

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.gamehok.adapter.FragmentAdapterMain
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class BattleDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle_description)

        Glide.with(this).load("https://res.cloudinary.com/ddut9isww/image/upload/v1719680004/cx8ntgr88glfctjqhghp.jpg").into(findViewById(R.id.eventImage))

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewpager)

        val tabAdapter = FragmentAdapterMain(this)
        viewPager.adapter = tabAdapter

        viewPager.setUserInputEnabled(false);

        TabLayoutMediator(tabLayout, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            val tabNames = listOf("Overview", "Players", "Rules", "Standings")
            tab.text = tabNames[position]
        }).attach()


    }

}