package com.example.islamiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamiapp.fragments.SebhaFragment
import com.example.islamiapp.databinding.ActivityHomeBinding
import com.example.islamiapp.fragments.HadethFragment
import com.example.islamiapp.fragments.QuranFragment
import com.example.islamiapp.fragments.RadioFragment


class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.islamiBottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.navigation_quran -> {
                    pushFragment(QuranFragment())
                }

                R.id.navigation_hadeth -> {
                    pushFragment(HadethFragment())
                }

                R.id.navigation_tasbeeh -> {
                    pushFragment(SebhaFragment())
                }

                R.id.navigation_radio -> {
                    pushFragment(RadioFragment())
                }
            }

            return@setOnItemSelectedListener true
        }
        binding.islamiBottomNavigationView.selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            binding.islamiFragmentContainer.id, fragment
        ).commit()
    }
}