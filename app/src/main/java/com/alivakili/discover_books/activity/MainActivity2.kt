package com.alivakili.discover_books.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alivakili.discover_books.fragment.DiscoverFragment
import com.alivakili.discover_books.fragment.LibraryFragment
import com.alivakili.discover_books.fragment.ProfileFragment
import com.alivakili.discover_books.R
import com.alivakili.discover_books.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    var preFragment: Fragment = DiscoverFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding=ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        setCurrFragment(DiscoverFragment())
        configureToolbar("Discover")

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.discover -> {
                    setCurrFragment(DiscoverFragment())
                    configureToolbar("Discover")
                    true
                }
                R.id.library -> {
                    setCurrFragment(LibraryFragment())
                    configureToolbar("Library")
                    true
                }
                R.id.profile -> {
                    setCurrFragment(ProfileFragment())
                    configureToolbar("Profile")
                    true
                }

                else -> {
                    Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
                    false
                }
            }
        }
    }



    private fun configureToolbar(title:String){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            this.title=title

        }
    }

    private fun setCurrFragment(fragment : Fragment){

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            commit()
        }

    }
}
