package com.binar.challenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge2.databinding.ActivityLayout1Binding
import com.binar.challenge2.gojek.BannerAdapter

class Layout1Activity : AppCompatActivity() {

    lateinit var binding: ActivityLayout1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayout1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val adapter = BannerAdapter()
        val layoutManager = LinearLayoutManager(this)
//        layoutManager.reverseLayout = false
        layoutManager.stackFromEnd = true
        binding.rvBanner.layoutManager = layoutManager
        binding.rvBanner.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.gojek_toolbar_menu, menu)
        return true
    }
}