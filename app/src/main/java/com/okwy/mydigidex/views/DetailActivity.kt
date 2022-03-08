package com.okwy.mydigidex.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.okwy.mydigidex.R
import com.okwy.mydigidex.databinding.ActivityDetailBinding
import com.okwy.mydigidex.util.Constants
import com.okwy.mydigidex.util.ConstantsDigimonLevel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            if (intent != null) {
                val name = intent.getStringExtra(Constants.NAME)
                digimonNameDetail.text = name
                digimonLevelDetail.text = intent.getStringExtra(Constants.LEVEL)
                Glide.with(root)
                    .load(intent.getStringExtra(Constants.IMG))
                    .centerInside()
                    .into(digimonImageDetail)

                digimonStoryDetail.text = when (intent.getStringExtra(Constants.LEVEL)) {
                    ConstantsDigimonLevel.FRESH.level -> getString(R.string.fresh).replace(
                        "{name}",
                        name!!
                    )
                    ConstantsDigimonLevel.IN_TRAINING.level -> getString(R.string.in_training).replace(
                        "{name}",
                        name!!
                    )
                    ConstantsDigimonLevel.ROOKIE.level -> getString(R.string.rookie).replace(
                        "{name}",
                        name!!
                    )
                    ConstantsDigimonLevel.CHAMPION.level -> getString(R.string.champion).replace(
                        "{name}",
                        name!!
                    )
                    ConstantsDigimonLevel.ARMOR.level -> getString(R.string.armor).replace(
                        "{name}",
                        name!!
                    )
                    ConstantsDigimonLevel.ULTIMATE.level -> getString(R.string.ultimate).replace(
                        "{name}",
                        name!!
                    )
                    else -> getString(R.string.mega).replace(
                        "{name}",
                        name!!
                    )
                }
            }
        }
    }
}