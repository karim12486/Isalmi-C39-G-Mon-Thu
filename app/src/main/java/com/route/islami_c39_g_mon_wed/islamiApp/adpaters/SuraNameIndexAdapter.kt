package com.route.islami_c39_g_mon_wed.islamiApp.adpaters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islami_c39_g_mon_wed.databinding.ItemSuraNameBinding
import com.route.islami_c39_g_mon_wed.islamiApp.adpaters.model.SuraNameIndex

class SuraNameIndexAdapter(val itemsList: List<SuraNameIndex>?) :
    Adapter<SuraNameIndexAdapter.SuraNameIndexViewHolder>() {

    var onItemClickListener: OnSuraItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraNameIndexViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSuraNameBinding.inflate(inflater, parent, false)
        return SuraNameIndexViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: SuraNameIndexViewHolder, position: Int) {
        val item = itemsList?.get(position) ?: return
        holder.bind(item)
        holder.binding.root.setOnClickListener {
            onItemClickListener?.onSuraClick(suraNameIndex = item, position)
        }
    }

    class SuraNameIndexViewHolder(val binding: ItemSuraNameBinding) : ViewHolder(binding.root) {
        fun bind(item: SuraNameIndex) {
            binding.suraIndex.text = "${item.index}"
            binding.suraName.text = item.name
        }
    }

    interface OnSuraItemClickListener {
        fun onSuraClick(suraNameIndex: SuraNameIndex, position: Int)
    }

}
