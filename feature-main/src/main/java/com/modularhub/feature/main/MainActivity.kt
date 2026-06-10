package com.modularhub.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.modularhub.feature.cart.CartFeature
import com.modularhub.feature.category.CategoryFeature
import com.modularhub.feature.home.HomeFeature
import com.modularhub.feature.main.databinding.ActivityMainBinding
import com.modularhub.feature.mine.MineFeature

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            switchTab(R.id.nav_home)
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            switchTab(item.itemId)
            true
        }
    }

    private fun switchTab(itemId: Int) {
        val fragment: Fragment = when (itemId) {
            R.id.nav_home -> HomeFeature.createFragment()
            R.id.nav_category -> CategoryFeature.createFragment()
            R.id.nav_cart -> CartFeature.createFragment()
            R.id.nav_mine -> MineFeature.createFragment()
            else -> HomeFeature.createFragment()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
