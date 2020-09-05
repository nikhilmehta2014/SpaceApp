package com.nikhil.spaceapp.data.network

import com.nikhil.spaceapp.feature.asteroid.dto.AsteroidDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface AsteroidService {

    @GET("neo/rest/v1/feed")
    suspend fun getAllAsteroidsData(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: Int
    ) : List<AsteroidDTO.NearEarthObjects.X20190304>
}