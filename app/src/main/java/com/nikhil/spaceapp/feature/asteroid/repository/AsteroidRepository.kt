package com.nikhil.spaceapp.feature.asteroid.repository

import com.nikhil.spaceapp.data.model.Result
import com.nikhil.spaceapp.feature.asteroid.dto.Asteroid

interface AsteroidRepository {

    suspend fun getAllAsteroidsData(): Result<List<Asteroid>>

}