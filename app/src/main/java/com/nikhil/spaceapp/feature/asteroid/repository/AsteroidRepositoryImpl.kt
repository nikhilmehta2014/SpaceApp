package com.nikhil.spaceapp.feature.asteroid.repository

import com.nikhil.spaceapp.data.model.Result
import com.nikhil.spaceapp.data.network.AsteroidService
import com.nikhil.spaceapp.feature.asteroid.dto.AsteroidDTO
import javax.inject.Inject

class AsteroidRepositoryImpl @Inject constructor(
    private val asteroidService: AsteroidService
) : AsteroidRepository {

    override suspend fun getAllAsteroidsData(): Result<List<AsteroidDTO.NearEarthObjects.X20190304>> {
        TODO("Not yet implemented")
    }
}