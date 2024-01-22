package com.route.islami_c39_g_mon_wed.islamiApp.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_c39_g_mon_wed.databinding.FragmentHadethBinding
import com.route.islami_c39_g_mon_wed.databinding.FragmentQuranBinding
import com.route.islami_c39_g_mon_wed.islamiApp.Constants
import com.route.islami_c39_g_mon_wed.islamiApp.HadethDetailsActivity
import com.route.islami_c39_g_mon_wed.islamiApp.adpaters.HadethAdapter

class HadethFragment : Fragment() {
    lateinit var adapter: HadethAdapter
    lateinit var binding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHadethBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HadethAdapter(null)
        binding.hadethRecyclerView.adapter = adapter
        readHadethFile()
    }

    fun readHadethFile() {
        val fileName = "ahadeeth.txt"
        //
        val suraContentAsString = requireContext().assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        // "   Hello World   ".trim()
        val ahadethList = suraContentAsString.trim().split("#")
        Log.e("TAG", "readHadethFile:  $ahadethList")
        Log.e("TAG", "readHadethFile Size:  ${ahadethList.size}")
        val titleHadethList = mutableListOf<String>() // []
        val descriptionHadethList = mutableListOf<String>()// []
        for (hadeth in ahadethList) {
            val mutableHadethList = hadeth.trim().split("\n")
            titleHadethList.add(mutableHadethList[0])

            descriptionHadethList.add(mutableHadethList.joinToString("\n"))
            // String
            // List<String>
        }

        Log.e("TAG123", "readHadethFile Title Hadeth List size: ${titleHadethList}")
        adapter.onHadethClickListener = object : HadethAdapter.OnHadethItemClickListener {
            override fun onHadethItemClick(hadethItemPosition: Int) {
                val intent = Intent(requireContext(), HadethDetailsActivity::class.java)
                val item = descriptionHadethList.get(hadethItemPosition) // Whole Hadeth
                intent.putExtra(Constants.EXTRA_HADETH_NAME, item)
                startActivity(intent)
            }
        }
        adapter.updateData(titleHadethList.toList())

        // Room Data Base -> Save items locally
        // SQLite -> Caching items
    }
}
