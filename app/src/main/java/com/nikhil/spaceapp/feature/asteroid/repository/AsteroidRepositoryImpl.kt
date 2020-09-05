package com.nikhil.spaceapp.feature.asteroid.repository

import com.nikhil.spaceapp.data.model.Result
import com.nikhil.spaceapp.data.network.AsteroidService
import com.nikhil.spaceapp.feature.asteroid.dto.AsteroidDTO
import com.nikhil.spaceapp.util.constants.NASA_API_KEY
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class AsteroidRepositoryImpl @Inject constructor(
    private val asteroidService: AsteroidService
) : AsteroidRepository {

    companion object {
        val date_yyyyMMdd = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val startDateFormat = date_yyyyMMdd.format(Date())
        val endDateFormat = date_yyyyMMdd.format(Date())
    }


    override suspend fun getAllAsteroidsData(): Result<List<AsteroidDTO.NearEarthObjects.X20190304>> {
        return try {
            val response = asteroidService.getAllAsteroidsData(
                startDateFormat,
                endDateFormat,
                NASA_API_KEY.toInt()
            )
            Result.Success(response)
        } catch (throwable: Throwable) {
            Result.Error(throwable)
        }
    }
}