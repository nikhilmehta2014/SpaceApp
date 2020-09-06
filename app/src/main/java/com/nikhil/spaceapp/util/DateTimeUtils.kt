package com.nikhil.spaceapp.util

import android.os.Build
import androidx.annotation.RequiresApi
import timber.log.Timber
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
object DateTimeUtils {

    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    fun getCurrentDate():String {
        val usersDesiredTimeZone = ZoneId.of("Asia/Kolkata")
        val now = ZonedDateTime.now(usersDesiredTimeZone)
        val dateInStringFormat = now.format(formatter)
        Timber.d("Date in String format = $dateInStringFormat")
        return dateInStringFormat
    }

    fun getFutureDate(numberOfDays: Int): String {
        val currentDate = LocalDate.now()
        val futureDate = currentDate.plusDays(numberOfDays.toLong())
        return futureDate.format(formatter)
    }
}