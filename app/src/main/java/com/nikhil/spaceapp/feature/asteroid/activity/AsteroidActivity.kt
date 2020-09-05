package com.nikhil.spaceapp.feature.asteroid.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.nikhil.spaceapp.R
import com.nikhil.spaceapp.databinding.ActivityAsteroidBinding
import com.nikhil.spaceapp.feature.asteroid.viewmodel.AsteroidViewModel
import com.nikhil.spaceapp.util.extensions.bindContentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AsteroidActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAsteroidBinding
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(AsteroidViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindContentView(R.layout.activity_asteroid)
        binding.viewModel=viewModel

        viewModel.getAllAsteroidsData()

    }
}