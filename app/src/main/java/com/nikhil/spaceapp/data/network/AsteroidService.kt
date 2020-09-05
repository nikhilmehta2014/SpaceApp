package com.nikhil.spaceapp.data.network

import retrofit2.http.GET

interface AsteroidService {

    @GET()
    suspend fun getAllAsteroidsData()
}