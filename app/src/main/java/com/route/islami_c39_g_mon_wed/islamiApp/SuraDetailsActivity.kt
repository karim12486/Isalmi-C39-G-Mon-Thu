package com.route.islami_c39_g_mon_wed.islamiApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.islami_c39_g_mon_wed.databinding.ActivitySuraDetailsBinding
import com.route.islami_c39_g_mon_wed.islamiApp.adpaters.VersesAdapter

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySuraDetailsBinding
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.icBack.setOnClickListener {
            finish()
        }
        val title = intent.getStringExtra(Constants.EXTRA_SURA_NAME)
        val index = intent.getIntExtra(Constants.EXTRA_INDEX_NAME, -1)
        binding.textToolbarTitle.text = title
        adapter = VersesAdapter(null)
        binding.suraDetailsRecyclerView.adapter = adapter
        readFromAssets(index)

    }

    fun readFromAssets(index: Int) {
        val fileName = "$index.txt"
        //
        val suraContentAsString = application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        // 2 seconds  4 seconds 1 second
        val verses = suraContentAsString.split("\n")
        adapter.updateData(verses)
    }

}