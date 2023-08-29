package com.example.manipulations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manipulations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // important

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        /*binding.lowerCaseButton.setOnClickListener {
            val name = binding.inputEditName.text.trim().toString()
            if (name.isEmpty()) {
                binding.inputEditName.error = "No name"
                return@setOnClickListener
            }
            val result = name.lowercase()
            binding.textViewMessage.text = "Hello $result in lower case"
        }

        binding.upperCaseButton.setOnClickListener {
            val name = binding.inputEditName.text.trim().toString()
            if (name.isEmpty()) {
                binding.inputEditName.error = "No name"
                return@setOnClickListener
            }
            val result = name.uppercase()
            binding.textViewMessage.text = "Hello $result in upper case"
        }

        binding.capitalizeButton.setOnClickListener {
            val name = binding.inputEditName.text.trim().toString()
            if (name.isEmpty()) {
                binding.inputEditName.error = "No name"
                return@setOnClickListener
            }
            val result = name.replaceFirstChar { it.uppercase() }
            binding.textViewMessage.text = "Hello $result with a capitalized letter"
        }

        binding.reverseButton.setOnClickListener {
            val name = binding.inputEditName.text
            if (name.isEmpty()) {
                binding.inputEditName.error = "No name"
                return@setOnClickListener
            }
            val result = name.reversed()
            binding.textViewMessage.text = "Hello $result in reverse letters"
        }*/
        val transformationButtons = listOf(
            binding.lowerCaseButton,
            binding.upperCaseButton,
            binding.capitalizeButton,
            binding.reverseButton
        )

        transformationButtons.forEach { button ->
            button.setOnClickListener {
                val name = binding.inputEditName.text.trim().toString()
                if (name.isEmpty()) {
                    binding.inputEditName.error = "No name"
                    return@setOnClickListener
                }

                val result = when (button.id) {
                    R.id.lower_case_button -> name.lowercase()
                    R.id.upper_case_button -> name.uppercase()
                    R.id.capitalize_button -> name.replaceFirstChar { it.uppercase() }
                    R.id.reverse_button -> name.reversed()
                    else -> ""
                }

                binding.textViewMessage.text = "Hello $result"
            }
        }
    }
}