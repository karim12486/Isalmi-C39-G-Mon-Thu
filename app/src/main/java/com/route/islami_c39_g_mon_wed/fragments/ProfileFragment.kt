package com.route.islami_c39_g_mon_wed.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_c39_g_mon_wed.R
import com.route.islami_c39_g_mon_wed.databinding.FragmentProfileBinding
import com.route.islami_c39_g_mon_wed.temp.SettingsAdapter
import com.route.islami_c39_g_mon_wed.temp.SettingsItem
import kotlin.random.Random

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var adapter: SettingsAdapter
    private lateinit var settingsList: MutableList<SettingsItem>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createSettingsList()
        adapter = SettingsAdapter(settingsList)
        binding.settingsRecyclerView.adapter = adapter
        Log.e("Profile Tag", "onViewCreated: Finished Profile Screen ")
    }

    fun createSettingsList() {
        settingsList = mutableListOf() // settingsList = new ArrayList<SettingsItem>()
        settingsList.add(
            SettingsItem(
                title = "4G and sim card settings",
                subtitle = "Sim card subtitle",
                icon = R.drawable.ic_4g
            )
        )
        settingsList.add(
            SettingsItem(
                title = "Accessibility & Settings",
                subtitle = "Accessibility subtitle"
            )
        )
        settingsList.add(
            SettingsItem(
                title = "Airplane Mode and settings",
                subtitle = "disable network and connectivity",
                icon = R.drawable.ic_airplane_mode
            )
        )
        // for(int i = 0 ; i < 100 ; i++)
//for(i in 100 downTo 0)
        for (i in 0..100) {
            val random = Random.nextInt(3)
            val item = settingsList.get(random)
            settingsList.add(item)
        }

    }

}