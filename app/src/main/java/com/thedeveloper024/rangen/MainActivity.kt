package com.thedeveloper024.rangen

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.thedeveloper024.rangen.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun displayResult(num: Int) {
            val str_number = NumberFormat.getNumberInstance().format(num)
            binding.generatedNumber.text = getString(R.string.generated_number, str_number)
        }

        binding.startButton.setOnClickListener {
            displayResult(0)
            binding.title.visibility = View.GONE
            binding.startButton.visibility = View.GONE
            binding.runLayout.visibility = View.VISIBLE
        }
    }
}