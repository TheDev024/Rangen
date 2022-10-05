package com.thedeveloper024.rangen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.thedeveloper024.rangen.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var generator: RandomGenerator
    private var randomResult: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        generator = RandomGenerator(0, 100)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            displayResult()
            binding.title.visibility = View.GONE
            binding.startButton.visibility = View.GONE
            binding.runLayout.visibility = View.VISIBLE
        }

        binding.minInputLayout.editText?.doOnTextChanged { _, _, _, _ ->
            if (binding.minInputField.text.toString() != "")
                generator.min = binding.minInputField.text.toString().toInt()
            else generator.min = 0
        }

        binding.maxInputLayout.editText?.doOnTextChanged { _, _, _, _ ->
            if (binding.maxInputField.text.toString() != "")
                generator.max = binding.maxInputField.text.toString().toInt()
            else generator.max = 0
        }

        binding.generateButton.setOnClickListener {
            generateNumber()
        }
    }

    private fun displayResult() {
        val strNumber = NumberFormat.getNumberInstance().format(randomResult)
        when (strNumber.length) {
            6 -> binding.generatedNumber.setTextSize(
                TypedValue.COMPLEX_UNIT_SP, 148f
            )
            5 -> binding.generatedNumber.setTextSize(
                TypedValue.COMPLEX_UNIT_SP, 186f
            )
            else -> binding.generatedNumber.setTextSize(
                TypedValue.COMPLEX_UNIT_SP, 224f
            )
        }
        binding.generatedNumber.text = getString(R.string.generated_number, strNumber)
    }

    private fun generateNumber() {
        if (generator.min >= generator.max) {
            val message = Toast.makeText(this, "Values are not correct!", Toast.LENGTH_SHORT)
            message.show()
        } else {
            randomResult = generator.generate()
            displayResult()
        }
    }
}