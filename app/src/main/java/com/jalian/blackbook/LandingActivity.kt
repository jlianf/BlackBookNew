package com.jalian.blackbook

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import com.jalian.blackbook.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    private val binding : ActivityLandingBinding by lazy {
        ActivityLandingBinding.inflate(layoutInflater)
    }

    private lateinit var  landingAdapter: LandingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpView()

        val appName = Public.APP_TABLE
        val isFirst = Public.IS_FIRST

        val sharePreference = SharePreferenceManager(this, appName)

        binding.tvSkip.setOnClickListener {
            intentTo(MainActivity::class.java)
            finish()
        }

        binding.btnVpNext.setOnClickListener{
            val currnetPosition = binding.vpLanding.currentItem
            if (currnetPosition == landingAdapter.itemCount - 1) {
                sharePreference.getBoolean(isFirst, false)
                intentTo(MainActivity::class.java)
                finish()
            } else {
                binding.vpLanding.setCurrentItem(currnetPosition + 1, true)
            }
        }
    }

    private fun setUpView() {
        val landingFragmentOne = LandingPageOneFragment()
        val landingFragmentTwo = LandingPageTwoFragment()

        landingAdapter = LandingAdapter(
            this,
            landingFragmentOne, landingFragmentTwo
        )
        binding.vpLanding.adapter = landingAdapter
        binding.dotIndicator.attachTo(binding.vpLanding)
    }
}