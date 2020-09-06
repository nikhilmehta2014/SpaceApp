package com.nikhil.spaceapp.feature.asteroid.viewmodel

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikhil.spaceapp.data.model.Result
import com.nikhil.spaceapp.feature.asteroid.dto.Asteroid
import com.nikhil.spaceapp.feature.asteroid.repository.AsteroidRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import timber.log.Timber

class AsteroidViewModel @ViewModelInject constructor(
    private val repo: AsteroidRepository
) : ViewModel() {

    private val _asteroidList = MutableLiveData<List<Asteroid>>()
    val asteroidList: LiveData<List<Asteroid>> = _asteroidList

    val showLoader = ObservableField<Boolean>()

    var asteroid: Asteroid? = null

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable.localizedMessage)
    }

    fun getAllAsteroidsData() {
        viewModelScope.launch(coroutineExceptionHandler) {
            showLoader.set(true)
            when (val result = repo.getAllAsteroidsData()) {
                is Result.Success -> {
                    showLoader.set(false)
                    Timber.d("AsteroidViewModel = ${result.data}")
                    _asteroidList.value = result.data
                }
                is Result.Error -> {
                    showLoader.set(false)
                    Timber.d("AsteroidViewModel = ${result.throwable.localizedMessage}")
                }
            }
        }
    }

    fun init(asteroid: Asteroid) {
        this.asteroid = asteroid
    }
}