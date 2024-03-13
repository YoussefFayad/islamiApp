package com.example.islamiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemHadethNameBinding

class HadethNameAdapter(private val hadethItemsList: MutableList<HadethNameIndex>) :
    RecyclerView.Adapter<HadethNameAdapter.HadethNameViewHolder>() {

    var onHadethClickListener: OnHadethClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethNameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHadethNameBinding.inflate(inflater, parent, false)
        return HadethNameViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hadethItemsList.size
    }

    override fun onBindViewHolder(holder: HadethNameViewHolder, position: Int) {
        val item = hadethItemsList.get(position) ?: return
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onHadethClickListener?.onHadethClick(item, position)
        }
    }

    interface OnHadethClickListener {
        fun onHadethClick(item: HadethNameIndex, position: Int)
    }

    fun addItems(newItems: List<HadethNameIndex>) {
        hadethItemsList.addAll(newItems)
        notifyDataSetChanged()
    }

    class HadethNameViewHolder(private val binding: ItemHadethNameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HadethNameIndex) {
            binding.hadethTextView.text = item.name
        }
    }
}
