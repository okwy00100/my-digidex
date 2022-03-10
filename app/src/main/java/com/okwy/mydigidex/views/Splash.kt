package com.okwy.mydigidex.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import com.okwy.mydigidex.R
import com.okwy.mydigidex.databinding.ActivitySplashBinding
import java.lang.Exception

class Splash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageLoaderAnimator()
        gotoMainActivity()

    }

    private fun gotoMainActivity() {
        binding.apply {
            imageLoaderInner.alpha = 0f
            imageLoaderInner.animate().setDuration(3000).alpha(1f).withEndAction {
                val intent = Intent(this@Splash, MainActivity::class.java)
                startActivity(intent)
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
    }

    private fun imageLoaderAnimator() {
        val rotate = RotateAnimation(
            0F, 359F,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotate.duration = 1000
        rotate.interpolator = LinearInterpolator()
        rotate.repeatCount = Animation.INFINITE
        binding.apply {
            imageLoader.startAnimation(rotate)
        }

    }
}