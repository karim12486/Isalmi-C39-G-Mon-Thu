package com.route.islami_c39_g_mon_wed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islami_c39_g_mon_wed.fragments.HomeFragment
import com.route.islami_c39_g_mon_wed.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    lateinit var homeTabTextView: TextView
    lateinit var profileTabTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Fragments <->  Facebook or whatsapp
        //                              Chats - Status - Calls
        homeTabTextView = findViewById(R.id.home_tab)
        profileTabTextView = findViewById(R.id.profile_tab)

        homeTabTextView.setOnClickListener {
            // Show or hide or replace fragment you need to supportFragmentManager
            pushFragment(HomeFragment())


        }
        profileTabTextView.setOnClickListener {
            pushFragment(ProfileFragment())
        }
    }

    // ImageView {
    //  
    // }
    // Git & Github (Version Control Systems (VCS))
    //
    // 20 Developers Working on same project ( Bad Approach ())
    // Version control Systems
    // Project -> Bottom Navigation View  -> 4 Tabs
    // 1.0 initial Commit -> Git Save (commit) -> Bottom Navigation View
    // 1.1 navigation Drawer -> Git Save (Commit) ->
    // Repository -> Local -> -> Remote
    //          1- UnVersioned Files States ->  initial Commit
    //          2- Ignored Files States
    //          3- Tracked (Versioned) Files States

    // View Binding
    fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }
}