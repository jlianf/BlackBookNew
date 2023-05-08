package com.jalian.blackbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jalian.blackbook.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    private val binding : ActivityLandingBinding by lazy {
        ActivityLandingBinding.inflate(layoutInflater)
    }

    private lateinit var  landingAdapter: LandingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvSkip.setOnClickListener {
            intentTo(MainActivity::class.java)
            finish()
        }

        binding.btnVpNext.setOnClickListener{
            val currnetPosition = binding.vpLanding.currentItem
            if (currnetPosition == landingAdapter.itemCount - 1) {
                intentTo(MainActivity::class.java)
                finish()
            } else {
                binding.vpLanding.setCurrentItem(currnetPosition + 1, true)
            }
        }
    }
}