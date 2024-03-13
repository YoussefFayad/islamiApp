package com.example.islamiapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islamiapp.adapters.HadethRecyclerAdapter
import com.example.islamiapp.databinding.ActivityHadethDatailsBinding
import com.example.islamiapp.databinding.ActivitySuraDetailsBinding
import java.io.InputStream

class HadethDatailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHadethDatailsBinding
    private lateinit var linesAdapter: HadethRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDatailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(Constants.EXTRA_Hadeth_NAME)
        binding.titleTextView.text = title

        val position = intent.getIntExtra(Constants.EXTRA_Hadeth_POSITION, -1)
        val filename = "h$position.txt"

        if (assets.list("")?.contains(filename) == true) {
            val inputStream: InputStream = assets.open(filename)
            val fileContent = inputStream.bufferedReader().use { it.readText() }
            val lines = fileContent.trim().split("\n")

            linesAdapter = HadethRecyclerAdapter(lines)
            binding.hadethDetailsRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@HadethDatailsActivity)
                adapter = linesAdapter
            }
        } else {
            Log.e("SuraDetailsActivity", "File not found: $filename")
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}