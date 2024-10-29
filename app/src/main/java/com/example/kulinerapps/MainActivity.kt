package com.example.kulinerapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.example.kulinerapps.databinding.ActivityMainBinding // Import binding yang dihasilkan

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Menggunakan View Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Menginflasi layout dengan View Binding
        setContentView(binding.root) // Mengatur konten dengan root dari binding

        val viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter // Mengakses viewPager dari binding

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Kuliner"
                1 -> tab.text = "Wisata"
            }
        }.attach()
    }
}
