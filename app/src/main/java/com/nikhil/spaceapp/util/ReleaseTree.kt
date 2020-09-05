package com.nikhil.spaceapp.util

import android.util.Log
import timber.log.Timber

class ReleaseTree : @org.jetbrains.annotations.NotNull Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        if (priority == Log.ERROR || priority == Log.WARN) {
            //SEND ERROR REPORTS TO YOUR Crashlytics.
        }
    }
}
