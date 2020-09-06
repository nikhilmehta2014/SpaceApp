package com.nikhil.spaceapp.feature.asteroid.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nikhil.spaceapp.R
import com.nikhil.spaceapp.databinding.ActivityAsteroidBinding
import com.nikhil.spaceapp.feature.asteroid.adapter.AsteroidAdapter
import com.nikhil.spaceapp.feature.asteroid.viewmodel.AsteroidViewModel
import com.nikhil.spaceapp.util.extensions.bindContentView
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AsteroidActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAsteroidBinding
    private var asteroidAdapter: AsteroidAdapter? = null

    /**
     * https://stackoverflow.com/a/60670866/4822110
     * Guide for replacing 'ViewModelProviders' with 'by viewModels()'
     */
    private val viewModel: AsteroidViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindContentView(R.layout.activity_asteroid)
        binding.viewModel = viewModel

        viewModel.getAllAsteroidsData()

        viewModel.asteroidList.observe(this, Observer {
            Timber.d("Size of Asteroid data = ${it.size}")
            binding.rvAsteroid.apply {
                asteroidAdapter = AsteroidAdapter(it)
                layoutManager = LinearLayoutManager(this@AsteroidActivity)
                adapter = asteroidAdapter
            }
        })
    }
}