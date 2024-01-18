package com.route.islami_c39_g_mon_wed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islami_c39_g_mon_wed.databinding.ActivityMainBinding
import com.route.islami_c39_g_mon_wed.fragments.HomeFragment
import com.route.islami_c39_g_mon_wed.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding  // null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Data Binding
        setContentView(binding.root)
        // Fragments <->  Facebook or whatsapp
        //                              Chats - Status - Calls
        pushFragment(HomeFragment())
        Log.e("TAG", "onCreate: ")
        // view Pager ->
        binding.homeTab.setOnClickListener {
            // Show or hide or replace fragment you need to supportFragmentManager
            pushFragment(HomeFragment())
            // Todo App -> Room Data Base ->  Sqlite -> Entity ->
        }
        binding.profileTab.setOnClickListener {
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
    // Local Repository
    // Github - Gitlab - BitBuckets


    // View Binding
    fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
        Log.e("TAG", "pushFragment: ")
        Log.e("TAG2", "pushFragment:2 ")
        // Pull Request
        // View Binding
        // XML Layout File -> Generated Java or Kotlin Class
    }
}