package com.route.islami_c39_g_mon_wed.islamiApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.islami_c39_g_mon_wed.R
import com.route.islami_c39_g_mon_wed.databinding.ActivityHadethDetailsBinding
import com.route.islami_c39_g_mon_wed.islamiApp.adpaters.VersesAdapter

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityHadethDetailsBinding
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val description = intent.getStringExtra(Constants.EXTRA_HADETH_NAME)
        val descriptionList = description?.split("\n")?.toMutableList()
        val title = descriptionList?.get(0)
        descriptionList?.removeAt(0)
        adapter = VersesAdapter(descriptionList)
        binding.suraDetailsRecyclerView.adapter = adapter
        binding.textToolbarTitle.text = title
        binding.icBack.setOnClickListener {
            finish()
        }
        // Dark -> Dark Mode

    }
}