package com.okwy.mydigidex.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.okwy.mydigidex.adapter.DigiAdapter
import com.okwy.mydigidex.arch.viewmodel.DigiViewModel
import com.okwy.mydigidex.databinding.ActivityMainBinding
import com.okwy.mydigidex.entity.Digimon
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), DigiAdapter.ListItemClickListener {
    private lateinit var binding : ActivityMainBinding

    private val viewModel: DigiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val digiAdapter = DigiAdapter(this)

        binding.apply {
            digiRecycler.apply {
                adapter = digiAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }


            viewModel.digimon.observe(this@MainActivity){ digimon ->
                digiAdapter.submitList(digimon)

            }
        }



    }

    override fun onListItemClick(digimon: Digimon, adapterPosition: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", digimon.name)
        intent.putExtra("img", digimon.img)
        intent.putExtra("level", digimon.level)
        startActivity(intent)

    }


}