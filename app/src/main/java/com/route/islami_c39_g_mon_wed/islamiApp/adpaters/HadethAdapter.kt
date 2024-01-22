package com.route.islami_c39_g_mon_wed.islamiApp.adpaters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islami_c39_g_mon_wed.databinding.ItemHadethBinding
import com.route.islami_c39_g_mon_wed.databinding.ItemVerseBinding

class HadethAdapter(var hadethList: List<String>?) : Adapter<HadethAdapter.VersesViewHolder>() {
    var onHadethClickListener: OnHadethItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHadethBinding.inflate(inflater, parent, false)
        return VersesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hadethList?.size ?: 0
    }

    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {
        val item = hadethList?.get(position) ?: return
        holder.binding.root.setOnClickListener {
            onHadethClickListener?.onHadethItemClick(position)
        }
        holder.bind(item)
    }

    fun updateData(verses: List<String>) {
        this.hadethList = verses
        notifyDataSetChanged() // Reload - Refresh
    }

    interface OnHadethItemClickListener {
        fun onHadethItemClick(hadethItemPosition: Int)

    }

    class VersesViewHolder(val binding: ItemHadethBinding) : ViewHolder(binding.root) {
        fun bind(verse: String) {
            binding.suraVerseItem.text = verse
        }
    }


}
