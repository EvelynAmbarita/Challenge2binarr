package com.binar.challenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge2.databinding.ActivityLayout1Binding
import com.binar.challenge2.gojek.BannerAdapter
import com.binar.challenge2.gojek.GridAdapter

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
//        layoutManager.stackFromEnd = true
        binding.rvBanner.layoutManager = layoutManager
        binding.rvBanner.adapter = adapter

        val listTitle = resources.getStringArray(R.array.grid_title_list)
        val listIcon = intArrayOf(R.drawable.ic_goride,
            R.drawable.ic_gocar,
            R.drawable.ic_gofood,
            R.drawable.ic_gosend,
            R.drawable.ic_gomart,
            R.drawable.ic_go_pulsa,
            R.drawable.ic_checkin,
            R.drawable.ic_lainnya)
        val gridAdapter = GridAdapter(this, listTitle,listIcon)
        binding.gvMenu.adapter = gridAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.gojek_toolbar_menu, menu)
        return true
    }
}