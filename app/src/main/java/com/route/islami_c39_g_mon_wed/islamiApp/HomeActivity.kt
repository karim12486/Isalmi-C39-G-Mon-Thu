package com.route.islami_c39_g_mon_wed.islamiApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.route.islami_c39_g_mon_wed.R
import com.route.islami_c39_g_mon_wed.databinding.ActivityHomeBinding
import com.route.islami_c39_g_mon_wed.islamiApp.fragments.HadethFragment
import com.route.islami_c39_g_mon_wed.islamiApp.fragments.QuranFragment
import com.route.islami_c39_g_mon_wed.islamiApp.fragments.RadioFragment
import com.route.islami_c39_g_mon_wed.islamiApp.fragments.TasbeehFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.islamiBottomNavigationView.setOnItemSelectedListener {
            // Switch(java) <-> if <-> when (kotlin)
            when (it.itemId) {
                R.id.navigation_quran -> {
                    pushFragment(QuranFragment())
                }

                R.id.navigation_hadeth -> {
                    pushFragment(HadethFragment())
                }

                R.id.navigation_tasbeeh -> {
                    pushFragment(TasbeehFragment())
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
        supportFragmentManager
            .beginTransaction()
            .replace(binding.islamiFragmentContainer.id, fragment)
            .commit()
    }

}