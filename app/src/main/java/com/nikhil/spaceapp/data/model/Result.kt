package com.nikhil.spaceapp.data.model

sealed class Result<out T : Any> {
    class Success<out T : Any>(val data: T) : Result<T>()
    class Error(val throwable: Throwable) : Result<Nothing>()
}