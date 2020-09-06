package com.nikhil.spaceapp.util

import timber.log.Timber

object ImageUtils {

    private const val URL_SPLASH_RANDOM = "https://images.unsplash.com/photo-1587815073078-f636169821e3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1275&q=80"

    fun getRandomImage():String{
        Timber.d("random image = $URL_SPLASH_RANDOM")
        return URL_SPLASH_RANDOM
    }
}