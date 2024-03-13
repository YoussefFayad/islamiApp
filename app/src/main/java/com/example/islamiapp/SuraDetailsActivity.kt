package com.example.islamiapp


import SuraDetailsAdapter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islamiapp.databinding.ActivitySuraDetailsBinding
import java.io.InputStream

class SuraDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuraDetailsBinding
    private lateinit var linesAdapter: SuraDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(Constants.EXTRA_SURA_NAME)
        binding.titleTextView.text = title

        val position = intent.getIntExtra(Constants.EXTRA_SURA_POSITION, -1)
        val filename = "$position.txt"

        if (assets.list("")?.contains(filename) == true) {
            val inputStream: InputStream = assets.open(filename)
            val fileContent = inputStream.bufferedReader().use { it.readText() }
            val lines = fileContent.trim().split("\n")

            linesAdapter = SuraDetailsAdapter(lines)
            binding.suraDetailsRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@SuraDetailsActivity)
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
