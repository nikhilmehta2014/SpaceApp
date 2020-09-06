package com.nikhil.spaceapp.util.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import timber.log.Timber

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    if (url != null) {
        val requestOption = RequestOptions()
        Timber.d("original image url: $url")
        Timber.d("trimmed image url: ${url.trim()}")

        /**
         * Verified that there is some issue with NASA API URL format that we are getting from API
         * as APOD(Astronomy Picture of the Day) API response URL:
         *      https://apod.nasa.gov/apod/image/2009/CrabNebula_Hubble_960.jpg
         * is working fine.
         */
        //
        Glide.with(imageView.context)
            .load(url)
//            .load("https://ssd.jpl.nasa.gov/sbdb.cgi")
//            .load("https://apod.nasa.gov/apod/image/2009/CrabNebula_Hubble_960.jpg")
            .apply(requestOption)
            .into(imageView)
    }
}