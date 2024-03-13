package com.example.islamiapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.ActivitySebhaaFragmentBinding

class SebhaFragment : Fragment() {

    lateinit var binding: ActivitySebhaaFragmentBinding
    var count = 0
    var rotation = 93F

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivitySebhaaFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countTasbeeh()
    }


    private fun countTasbeeh() {
        binding.tasbeeh.setOnClickListener {
            onClickMainFunction()

            if (count == 33 && binding.tasbeeh.text == "سبحان الله") {
                resetTheCounter()
                binding.tasbeeh.text = "الله اكبر"

            } else if (count == 33 && binding.tasbeeh.text == "الله اكبر") {
                resetTheCounter()
                binding.tasbeeh.text = "استغفر الله"

            } else if (count == 33 && binding.tasbeeh.text == "استغفر الله") {
                resetTheCounter()
                binding.tasbeeh.text = "الحمد لله"

            } else if (count == 33 && binding.tasbeeh.text == "الحمد لله") {
                resetTheCounter()
                binding.tasbeeh.text = "سبحان الله"
            }
        }
    }

    private fun resetTheCounter() {
        count = 0
        binding.tasbeehCount.text = count.toString()
    }

    private fun onClickMainFunction() {
        count++
        rotation += 93F
        binding.body.rotation = rotation
        binding.tasbeehCount.text = count.toString()
    }

}