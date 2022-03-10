package com.binar.challenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.challenge2.databinding.ActivityLayout2Binding
import com.binar.challenge2.tokped.MenuAdapter

class Layout2Activity : AppCompatActivity() {

    lateinit var binding: ActivityLayout2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayout2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        val listTitle = resources.getStringArray(R.array.menu_tokped_list_title)
//        val listIcon = intArrayOf(R.drawable.ic_official_selected,
//            R.drawable.ic_lainnya,
//            R.drawable.ic_picnic_basket_picnic_svgrepo_com,
//            R.drawable.ic_electronics_svgrepo_com,
//            R.drawable.ic_scroll_svgrepo_com,
//            R.drawable.ic_stationery_svgrepo_com,
//            R.drawable.ic_money_svgrepo_com,
//            R.drawable.ic_plane_svgrepo_com,
//            R.drawable.ic_party_hat_birthday_svgrepo_com)
//
//        val menuAdapter = MenuAdapter(this,listTitle, listIcon)
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
//        binding.rvMenu.adapter = menuAdapter

    }
}