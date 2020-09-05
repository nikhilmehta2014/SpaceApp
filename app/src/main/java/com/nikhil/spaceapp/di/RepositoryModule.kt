package com.nikhil.spaceapp.di

import com.nikhil.spaceapp.data.network.AsteroidService
import com.nikhil.spaceapp.feature.asteroid.repository.AsteroidRepository
import com.nikhil.spaceapp.feature.asteroid.repository.AsteroidRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    fun provideAsteroidRepository(asteroidService: AsteroidService): AsteroidRepository = AsteroidRepositoryImpl(asteroidService)
}