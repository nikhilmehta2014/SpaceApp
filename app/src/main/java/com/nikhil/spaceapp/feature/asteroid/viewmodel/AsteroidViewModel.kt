package com.nikhil.spaceapp.feature.asteroid.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikhil.spaceapp.feature.asteroid.repository.AsteroidRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import timber.log.Timber

class AsteroidViewModel @ViewModelInject constructor(
    private val repo: AsteroidRepository
) : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable.localizedMessage)
    }

    fun getAllAsteroidsData() {
        viewModelScope.launch(coroutineExceptionHandler) {
            repo.getAllAsteroidsData()
        }
    }
}