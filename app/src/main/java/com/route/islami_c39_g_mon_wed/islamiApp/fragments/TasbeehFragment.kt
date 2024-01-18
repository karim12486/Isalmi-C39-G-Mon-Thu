package com.route.islami_c39_g_mon_wed.islamiApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_c39_g_mon_wed.databinding.FragmentQuranBinding
import com.route.islami_c39_g_mon_wed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {

    lateinit var binding: FragmentTasbeehBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasbeehBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
