package com.nikhil.spaceapp

import android.app.Application
import com.nikhil.spaceapp.util.ReleaseTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class AsteroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return String.format(
                        "Class:%s: Line: %s, Method: %s",
                        super.createStackElementTag(element),
                        element.lineNumber,
                        element.methodName
                    )
                }
            })
        } else {
            Timber.plant(ReleaseTree())
        }
    }
}