package com.route.islami_c39_g_mon_wed.islamiApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_c39_g_mon_wed.databinding.FragmentQuranBinding
import com.route.islami_c39_g_mon_wed.islamiApp.adpaters.SuraNameIndexAdapter
import com.route.islami_c39_g_mon_wed.islamiApp.adpaters.model.SuraNameIndex
import com.route.islami_c39_g_mon_wed.islamiApp.adpaters.model.arSuras

class QuranFragment : Fragment() {
    lateinit var adapter: SuraNameIndexAdapter
    lateinit var binding: FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuranBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val suras = arSuras.mapIndexed { position, name ->
            SuraNameIndex(name, position + 1)
        }
        adapter = SuraNameIndexAdapter(suras)
        binding.surasRecyclerView.adapter = adapter

    }
}
