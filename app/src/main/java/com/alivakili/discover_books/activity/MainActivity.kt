package com.alivakili.discover_books.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.alivakili.discover_books.fragment.OnboardingFragment1
import com.alivakili.discover_books.fragment.OnboardingFragment2
import com.alivakili.discover_books.fragment.OnboardingFragment3
import com.alivakili.discover_books.fragment.OnboardingFragment4
import com.alivakili.discover_books.adapter.MainFragmentAdapter
import com.alivakili.discover_books.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MainFragmentAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        if (sharedPref.getBoolean("isFirstLaunch", true)) {
            // This is the first launch, set the flag to false
            sharedPref.edit().putBoolean("isFirstLaunch", false).apply()
        } else {
            // This is not the first launch, start the second activity and finish the first activity
            val intent = Intent(this, MainActivity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
            return
        }
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = MainFragmentAdapter(supportFragmentManager, lifecycle)
        // add Fragments in your ViewPagerFragmentAdapter class
        adapter.addFragment(OnboardingFragment1())
        adapter.addFragment(OnboardingFragment2())
        adapter.addFragment(OnboardingFragment3())
        adapter.addFragment(OnboardingFragment4())

        // set Orientation in your ViewPager2

        // set Orientation in your ViewPager2
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.viewPager2.adapter = adapter
    }




}