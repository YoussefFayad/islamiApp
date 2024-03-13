package com.example.islamiapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islamiapp.Constants
import com.example.islamiapp.HadethDatailsActivity
import com.example.islamiapp.adapters.HadethNameAdapter
import com.example.islamiapp.adapters.HadethNameIndex
import com.example.islamiapp.databinding.FragmentHadethBinding
import com.example.islamiapp.adapters.hadethNamesList

class HadethFragment : Fragment() {
    private lateinit var binding: FragmentHadethBinding
    private lateinit var adapter: HadethNameAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadethBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hadethList = hadethNamesList.mapIndexed { index, item ->
            HadethNameIndex(item, index + 1)
        }

        adapter = HadethNameAdapter(hadethList.toMutableList())

        adapter.onHadethClickListener = object : HadethNameAdapter.OnHadethClickListener {
            override fun onHadethClick(item: HadethNameIndex, position: Int) {
                val intent = Intent(requireContext(), HadethDatailsActivity::class.java)
                intent.putExtra(Constants.EXTRA_Hadeth_NAME, item.name)
                intent.putExtra(Constants.EXTRA_Hadeth_POSITION, item.index)
                startActivity(intent)
            }
        }

        binding.hadethNamesRecyclerView.adapter = adapter
        binding.hadethNamesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}

