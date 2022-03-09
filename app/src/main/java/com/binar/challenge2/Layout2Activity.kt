package com.binar.challenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.binar.challenge2.databinding.ActivityLayout2Binding

class Layout2Activity : AppCompatActivity() {

    lateinit var binding: ActivityLayout2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayout2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}