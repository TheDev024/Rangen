package com.thedeveloper024.rangen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.thedeveloper024.rangen.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var generator: RandomGenerator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        generator = RandomGenerator(0, 100)
        setContentView(binding.root)

        fun displayResult(num: Int) {
            val strNumber = NumberFormat.getNumberInstance().format(num)
            binding.generatedNumber.text = getString(R.string.generated_number, strNumber)
        }

        binding.startButton.setOnClickListener {
            displayResult(0)
            binding.title.visibility = View.GONE
            binding.startButton.visibility = View.GONE
            binding.runLayout.visibility = View.VISIBLE
        }

        binding.minInputLayout.editText?.doOnTextChanged { _, _, _, _ ->
            generator.min = binding.minInputField.text.toString().toInt()
        }

        binding.maxInputLayout.editText?.doOnTextChanged { _, _, _, _ ->
            generator.max = binding.maxInputField.text.toString().toInt()
        }

        binding.generateButton.setOnClickListener {
            displayResult(generator.generate())
        }
    }
}