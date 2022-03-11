package com.binar.challenge2

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.binar.challenge2.databinding.ActivityLayout2Binding
import com.bumptech.glide.Glide

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

        Glide.with(this).load(R.drawable.produk_1).fitCenter().into(binding.barangLayout1.imageView19)
        Glide.with(this).load(R.drawable.produk_2).fitCenter().into(binding.barangLayout2.imageView19)
        Glide.with(this).load(R.drawable.produk_3).fitCenter().into(binding.barangLayout3.imageView19)
        Glide.with(this).load(R.drawable.produk_4).fitCenter().into(binding.barangLayout4.imageView19)

        Glide.with(this).load(R.drawable.video_1).fitCenter().into(binding.videoLayout1.imageView19)
        Glide.with(this).load(R.drawable.video_2).fitCenter().into(binding.videoLayout2.imageView19)
        Glide.with(this).load(R.drawable.video_3).fitCenter().into(binding.videoLayout3.imageView19)
        Glide.with(this).load(R.drawable.video_4).fitCenter().into(binding.videoLayout4.imageView19)

        object : CountDownTimer(600000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                binding.tvWaktu.text = "${millisUntilFinished/1000/60} menit ${millisUntilFinished/1000%60} detik"
//                Log.i("timer","${millisUntilFinished/1000/60} menit ${millisUntilFinished/1000%60} detik")
            }

            override fun onFinish() {
                binding.tvWaktu.text = "promo selesai"
            }
        }.start()

        var isAlreadyAnimateWhite = false
        var isAlreadyAnimateGreen = true

        binding.nestedScrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->

            val headerHeight = binding.header.height
            when {
                scrollY>headerHeight -> {
                    changeToolbarStyle(false)
                    val window = this.window
                    val greenTokped = ContextCompat.getColor(this, R.color.tokped_primary)
                    val white = ContextCompat.getColor(this, R.color.white)
                    WindowInsetsControllerCompat(window,window.decorView).isAppearanceLightStatusBars = true
                    if (!isAlreadyAnimateWhite){
                        val colorAnimate = ValueAnimator.ofObject(ArgbEvaluator(),greenTokped,white)
                        colorAnimate.addUpdateListener {
                            window.statusBarColor = it.animatedValue as Int
                            binding.include.clToolbar.setBackgroundColor(it.animatedValue as Int)
                        }
                        colorAnimate.duration = 250
                        colorAnimate.start()
                        isAlreadyAnimateWhite = true
                        isAlreadyAnimateGreen = false
                    }
                }

                else -> {

                    changeToolbarStyle(true)
                    val window = this.window
                    val greenTokped = ContextCompat.getColor(this, R.color.tokped_primary)
                    val white = ContextCompat.getColor(this, R.color.white)
                    WindowInsetsControllerCompat(window,window.decorView).isAppearanceLightStatusBars = false

                    if (!isAlreadyAnimateGreen){
                        val colorAnimate = ValueAnimator.ofObject(ArgbEvaluator(),white,greenTokped)
                        colorAnimate.addUpdateListener {
                            window.statusBarColor = it.animatedValue as Int
                            binding.include.clToolbar.setBackgroundColor(it.animatedValue as Int)
                        }
                        colorAnimate.duration = 250
                        colorAnimate.start()
                        isAlreadyAnimateWhite = false
                        isAlreadyAnimateGreen = true
                    }
                }
            }
        }






    }

    private fun changeToolbarStyle(status: Boolean){

        if(status){
            binding.include.clToolbar.elevation = 2f
            binding.include.svSearch.background =
                ResourcesCompat.getDrawable(resources, R.drawable.search_bar_bordered,theme)
            binding.include.imageView.setColorFilter(ContextCompat.getColor(this,R.color.white), android.graphics.PorterDuff.Mode.SRC_IN)
            binding.include.imageView12.setColorFilter(ContextCompat.getColor(this,R.color.white), android.graphics.PorterDuff.Mode.SRC_IN)
            binding.include.imageView13.setColorFilter(ContextCompat.getColor(this,R.color.white), android.graphics.PorterDuff.Mode.SRC_IN)
            binding.include.imageView14.setColorFilter(ContextCompat.getColor(this,R.color.white), android.graphics.PorterDuff.Mode.SRC_IN)
        }else{
            binding.include.svSearch.background =
                ResourcesCompat.getDrawable(resources, R.drawable.search_bar_bordered,theme)
            binding.include.imageView.setColorFilter(ContextCompat.getColor(this,R.color.gojek_text_active), android.graphics.PorterDuff.Mode.SRC_IN)
            binding.include.imageView12.setColorFilter(ContextCompat.getColor(this,R.color.gojek_text_active), android.graphics.PorterDuff.Mode.SRC_IN)
            binding.include.imageView13.setColorFilter(ContextCompat.getColor(this,R.color.gojek_text_active), android.graphics.PorterDuff.Mode.SRC_IN)
            binding.include.imageView14.setColorFilter(ContextCompat.getColor(this,R.color.gojek_text_active), android.graphics.PorterDuff.Mode.SRC_IN)
        }

    }
}