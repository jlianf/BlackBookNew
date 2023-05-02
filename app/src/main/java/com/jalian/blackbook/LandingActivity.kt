package com.jalian.blackbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jalian.blackbook.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    private val binding : ActivityLandingBinding by lazy {
        ActivityLandingBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}