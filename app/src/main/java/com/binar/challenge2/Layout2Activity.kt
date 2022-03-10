package com.binar.challenge2

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.binar.challenge2.databinding.ActivityLayout2Binding

class Layout2Activity : AppCompatActivity() {

    lateinit var binding: ActivityLayout2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayout2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.barangLayout1.progressBar2.isEnabled = false
        binding.barangLayout2.progressBar2.isEnabled = false
        binding.barangLayout3.progressBar2.isEnabled = false
        binding.barangLayout4.progressBar2.isEnabled = false

        binding.nestedScrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            Log.i("scroll",scrollY.toString())
            val headerHeight = binding.header.height
            if (scrollY>headerHeight){
                binding.include.clToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                val window = this.window
//                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
//                window.statusBarColor = ContextCompat.getColor(this, R.color.transparent)
                binding.include.svSearch.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.search_bar_bordered,theme)
                binding.include.imageView.setColorFilter(ContextCompat.getColor(this,R.color.black), android.graphics.PorterDuff.Mode.SRC_IN)
                binding.include.imageView12.setColorFilter(ContextCompat.getColor(this,R.color.black), android.graphics.PorterDuff.Mode.SRC_IN)
                binding.include.imageView13.setColorFilter(ContextCompat.getColor(this,R.color.black), android.graphics.PorterDuff.Mode.SRC_IN)
                binding.include.imageView14.setColorFilter(ContextCompat.getColor(this,R.color.black), android.graphics.PorterDuff.Mode.SRC_IN)
            }else{
                binding.include.clToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.tokped_primary))
                val window = this.window

//                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                window.statusBarColor = ContextCompat.getColor(this, R.color.tokped_primary)

                binding.include.clToolbar.elevation = 2f
                binding.include.svSearch.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.search_bar_bordered,theme)
                binding.include.imageView.setColorFilter(ContextCompat.getColor(this,R.color.white), android.graphics.PorterDuff.Mode.SRC_IN)
                binding.include.imageView12.setColorFilter(ContextCompat.getColor(this,R.color.white), android.graphics.PorterDuff.Mode.SRC_IN)
                binding.include.imageView13.setColorFilter(ContextCompat.getColor(this,R.color.white), android.graphics.PorterDuff.Mode.SRC_IN)
                binding.include.imageView14.setColorFilter(ContextCompat.getColor(this,R.color.white), android.graphics.PorterDuff.Mode.SRC_IN)

            }
        }



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