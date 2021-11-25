package com.example.myproject

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    var data = arrayOf("District Code","Location","Beaches Of India")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tl = findViewById<TabLayout>(R.id.tabLayout)
        var pager = findViewById<ViewPager2>(R.id.viewPager2)

        pager.adapter = MyAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tl,pager){
                tab,position->
            tab.text = data[position]
        }.attach()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(101, 11 , 1, "Beach Animation")
        menu?.add(101, 12 , 2, "Gujarat Map Tweened Animation")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            11 -> { startActivity(Intent(applicationContext,BeachAnimationActivity::class.java)) }
            12 -> { startActivity(Intent(applicationContext,GujaratMapAnimationActivity::class.java)) }
        }
        return super.onOptionsItemSelected(item)
    }

}