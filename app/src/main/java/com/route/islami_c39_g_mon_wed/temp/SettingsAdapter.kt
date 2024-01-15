package com.route.islami_c39_g_mon_wed.temp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islami_c39_g_mon_wed.R

class SettingsAdapter(val settingsItems: List<SettingsItem>?) :
    Adapter<SettingsAdapter.SettingsViewHolder>() {
    // 2- Declare an interface instance
    var onSettingsItemClickListener: OnSettingsItemClickListener? = null
    var onIconSettingsClickListener: OnSettingsItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_settings, parent, false)
        return SettingsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return settingsItems?.size ?: 0
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        val item = settingsItems?.get(position) ?: return
        holder.title.text = item.title
        holder.subtitle.text = item.subtitle
        holder.settingsIcon.setImageResource(item.icon)
        // 1- Bad Approach ->
        //              1-  Memory Leak -> Context
        //              2-  Reusability ->
        //              3-  Single Responsibility Principle -> `S`OLID Design Princpiles
        //                                                  // Single Responsibility Principle
//        holder.settingsView.setOnClickListener { // Activity A -> navigate to Details Actitvity
        //Activity B -> Toast
        // Logic
//            val intent = Intent(context, SettingsDetailsActivity::class.java)
        //  -> Activity
//            intent.putExtra("title", item.title)
//            intent.putExtra("subtitle", item.subtitle)
//            context.startActivity(intent)
//    }

        // 2- Interface Callback <-> Delegate
        //
        holder.settingsView.setOnClickListener {
            // 3- Call the abstract method from declared instance
            onSettingsItemClickListener?.onSettingsItemClick(item, position)
        }
        holder.settingsIcon.setOnClickListener {
            onIconSettingsClickListener?.onSettingsItemClick(item, position)
        }
    }

    // 1- Create An Interface
    interface OnSettingsItemClickListener {
        fun onSettingsItemClick(item: SettingsItem, position: Int)
    }


    class SettingsViewHolder(val settingsView: View) : ViewHolder(settingsView) {

        val title: TextView
        val subtitle: TextView
        val settingsIcon: ImageView

        init {
            title = settingsView.findViewById(R.id.settings_title)
            subtitle = settingsView.findViewById(R.id.settings_subtitle)
            settingsIcon = settingsView.findViewById(R.id.settings_icon)
        }
    }


}