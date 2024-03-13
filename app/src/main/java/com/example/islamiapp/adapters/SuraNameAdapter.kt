package com.example.islamiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.databinding.ItemSuraNameBinding

class SuraNameAdapter( var suraItemsList: List<SuraNameIndex>?)
    : Adapter<SuraNameAdapter.SuraNameViewHolder>() {
    var onSuraClickListener: OnSuraClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraNameViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemSuraNameBinding.inflate(inflater, parent, false)
        return SuraNameViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return suraItemsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: SuraNameViewHolder, position: Int) {
        val item = suraItemsList?.get(position) ?: return
        holder.bind(item)
        holder.binding.root.setOnClickListener {
            onSuraClickListener?.onSuraClick(item, position)
        }
    }

    interface OnSuraClickListener {
        fun onSuraClick(item: SuraNameIndex, position: Int)
    }

    class SuraNameViewHolder(val binding: ItemSuraNameBinding) : ViewHolder(binding.root) {
        fun bind(item: SuraNameIndex) {
            binding.suraName.text = item.name
            binding.suraIndex.text = "${item.index}"
        }
    }
}
