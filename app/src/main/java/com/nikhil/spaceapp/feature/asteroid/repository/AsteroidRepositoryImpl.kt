package com.nikhil.spaceapp.feature.asteroid.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.nikhil.spaceapp.data.model.Result
import com.nikhil.spaceapp.feature.asteroid.dto.Asteroid
import com.nikhil.spaceapp.data.network.AsteroidService
import com.nikhil.spaceapp.feature.asteroid.util.AsteroidTransformer
import com.nikhil.spaceapp.util.DateTimeUtils
import com.nikhil.spaceapp.util.constants.NASA_API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AsteroidRepositoryImpl @Inject constructor(
    private val asteroidService: AsteroidService
) : AsteroidRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getAllAsteroidsData(): Result<List<Asteroid>> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val response = asteroidService.getAllAsteroidsData(
                    DateTimeUtils.getCurrentDate(),
                    DateTimeUtils.getFutureDate(4),
                    NASA_API_KEY
                )
                val asteroidList = AsteroidTransformer(response).transform()
                Result.Success(asteroidList)
            } catch (throwable: Throwable) {
                Result.Error(throwable)
            }
        }
}