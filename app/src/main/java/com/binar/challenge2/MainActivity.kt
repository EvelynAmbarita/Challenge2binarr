package com.binar.challenge2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.challenge2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLayout1.setOnClickListener {
            val intent = Intent(this, Layout1Activity::class.java)
            startActivity(intent)
        }

        binding.btnLayout2.setOnClickListener {
            val intent = Intent(this, Layout2Activity::class.java)
            startActivity(intent)
        }

    }
}