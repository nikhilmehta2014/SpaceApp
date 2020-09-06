package com.nikhil.spaceapp.feature.detail.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nikhil.spaceapp.R
import com.nikhil.spaceapp.databinding.ActivityAsteroidDetailBinding
import com.nikhil.spaceapp.feature.asteroid.dto.Asteroid
import com.nikhil.spaceapp.feature.asteroid.viewmodel.AsteroidViewModel
import com.nikhil.spaceapp.util.extensions.bindContentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AsteroidDetailActivity : AppCompatActivity() {

    companion object {

        const val KEY_ASTEROID = "asteroid"

        fun getStartIntent(context: Context, asteroid: Asteroid): Intent {
            return Intent(context, AsteroidDetailActivity::class.java).apply {
                // data goes here
                putExtra(KEY_ASTEROID, asteroid)
            }
        }
    }

    private lateinit var binding: ActivityAsteroidDetailBinding
    private val viewModel: AsteroidViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindContentView(R.layout.activity_asteroid_detail)
        binding.viewModel = viewModel

        val asteroid = intent.getSerializableExtra(KEY_ASTEROID) as Asteroid
        viewModel.init(asteroid)

    }

}